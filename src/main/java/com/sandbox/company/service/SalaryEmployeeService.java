package com.sandbox.company.service;

import java.util.List;

import com.sandbox.company.entity.SalaryEmployee;

public interface SalaryEmployeeService {

    List<SalaryEmployee> getSalaryEmployees();

    SalaryEmployee getSalaryEmployee(Long id);

    SalaryEmployee saveSalaryEmployee(SalaryEmployee salaryEmployee, Long id);

    SalaryEmployee updateSalaryEmployeeSalaryRate(double salaryRate, Long id);

    SalaryEmployee updateSalaryEmployeeFullTime(boolean fullTime, Long id);

    void deleteSalaryEmployee(Long id);

}
