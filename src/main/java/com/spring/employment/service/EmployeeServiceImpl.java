package com.spring.employment.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.employment.entity.Employer;
import com.spring.employment.entity.Employee;
import com.spring.employment.exception.DeleteException;
import com.spring.employment.exception.EmployeeNotFoundException;
import com.spring.employment.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return unwrapEmployee(employee, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Set<Employer> getEmployedEmployers(Long id) {
        Employee employee = getEmployee(id);

        return employee.getEmployers();
    }

    static Employee unwrapEmployee(Optional<Employee> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EmployeeNotFoundException(id);
    }
}
