package com.sandbox.company.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.SalaryEmployee;
import com.sandbox.company.exception.DeleteException;
import com.sandbox.company.exception.EmployeeNotFoundException;
import com.sandbox.company.exception.SalaryEmployeeNotFoundException;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.SalaryEmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SalaryEmployeeServiceImpl implements SalaryEmployeeService {

    private EmployeeRepository employeeRepository;
    private SalaryEmployeeRepository salaryEmployeeRepository;

    @Override
    public List<SalaryEmployee> getSalaryEmployees() {
        return (List<SalaryEmployee>) salaryEmployeeRepository.findAll();
    }

    @Override
    public SalaryEmployee getSalaryEmployee(Long id) {
        return salaryEmployeeRepository.findById(id).get();
    }

    @Override
    public SalaryEmployee saveSalaryEmployee(SalaryEmployee salaryEmployee, Long id) {
        Employee employee = EmployeeServiceImpl.unwrapEmployee(employeeRepository.findById(id), id);
        if (!employeeRepository.findById(id).isPresent())
            throw new EmployeeNotFoundException(id);

        salaryEmployee.setEmployee(employee);

        return salaryEmployeeRepository.save(salaryEmployee);
    }

    @Override
    public SalaryEmployee updateSalaryEmployeeSalaryRate(BigDecimal salaryRate, Long id) {
        Optional<SalaryEmployee> salaryEmployee = salaryEmployeeRepository.findByEmployeeId(id);
        SalaryEmployee unwrappedSalaryEmployee = unwrapSalaryEmployee(salaryEmployee, id);

        unwrappedSalaryEmployee.setSalaryRate(salaryRate);

        return salaryEmployeeRepository.save(unwrappedSalaryEmployee);
    }

    @Override
    public SalaryEmployee updateSalaryEmployeeFullTime(boolean fullTime, Long id) {
        Optional<SalaryEmployee> salaryEmployee = salaryEmployeeRepository.findByEmployeeId(id);
        SalaryEmployee unwrappedSalaryEmployee = unwrapSalaryEmployee(salaryEmployee, id);

        unwrappedSalaryEmployee.setFullTime(fullTime);

        return salaryEmployeeRepository.save(unwrappedSalaryEmployee);
    }

    @Override
    public void deleteSalaryEmployee(Long id) {
        Optional<SalaryEmployee> salaryEmployee = salaryEmployeeRepository.findByEmployeeId(id);

        if (salaryEmployee.isPresent())
            salaryEmployeeRepository.deleteByEmployeeId(id);
        else
            throw new DeleteException();
    }

    static SalaryEmployee unwrapSalaryEmployee(Optional<SalaryEmployee> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new SalaryEmployeeNotFoundException(id);
    }

}
