package com.sandbox.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.exception.DeleteException;
import com.sandbox.company.exception.EmployeeNotFoundException;
import com.sandbox.company.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeFirstName(String firstName, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setFirstName(firstName);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public Employee updateEmployeeLastName(String lastName, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setLastName(lastName);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public Employee updateEmployeeAddress(String Address, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setAddress(Address);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public Employee updateEmployeeCity(String City, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setCity(City);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public Employee updateEmployeeState(String state, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setState(state);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public Employee updateEmployeeEmail(String email, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee unwrappedEmployee = unwrapEmployee(employee, id);

        unwrappedEmployee.setEmail(email);

        return employeeRepository.save(unwrappedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent())
            employeeRepository.deleteById(id);
        else
            throw new DeleteException();
    }

    static Employee unwrapEmployee(Optional<Employee> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EmployeeNotFoundException(id);
    }

}
