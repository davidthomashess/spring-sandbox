package com.spring.employment.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.employment.entity.Employer;
import com.spring.employment.entity.Employee;
import com.spring.employment.exception.EmployerNotFoundException;
import com.spring.employment.exception.DeleteException;
import com.spring.employment.exception.EmployeeDataIntegrityException;
import com.spring.employment.repository.EmployerRepository;
import com.spring.employment.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepository employerRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public Employer getEmployer(Long id) {
        Optional<Employer> employer = employerRepository.findById(id);

        return unwrapEmployer(employer, id);
    }

    @Override
    public Employer saveEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public void deleteEmployer(Long id) {
        Optional<Employer> employer = employerRepository.findById(id);

        if (employer.isPresent()) {
            employerRepository.deleteById(id);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public List<Employer> getEmployers() {
        return (List<Employer>) employerRepository.findAll();
    }

    @Override
    public Employer addEmployeeToEmployer(Long employeeId, Long employerId) {
        Employer employer = getEmployer(employerId);
        Set<Employee> employedEmployees = getEmployedEmployees(employerId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee unwrappedEmployee = EmployeeServiceImpl.unwrapEmployee(employee, employeeId);

        for (Employee employedEmployee : employedEmployees) {
            if (employedEmployee.getId().equals(employeeId)) {
                throw new EmployeeDataIntegrityException(employeeId, employerId);
            }
        }

        employer.getEmployees().add(unwrappedEmployee);

        return employerRepository.save(employer);
    }

    @Override
    public Set<Employee> getEmployedEmployees(Long id) {
        Employer employer = getEmployer(id);

        return employer.getEmployees();
    }

    static Employer unwrapEmployer(Optional<Employer> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EmployerNotFoundException(id);
    }

}
