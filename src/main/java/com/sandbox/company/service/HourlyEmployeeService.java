package com.sandbox.company.service;

import java.math.BigDecimal;
import java.util.List;

import com.sandbox.company.entity.HourlyEmployee;

public interface HourlyEmployeeService {

    List<HourlyEmployee> getHourlyEmployees();

    HourlyEmployee getHourlyEmployee(Long id);

    HourlyEmployee saveHourlyEmployee(HourlyEmployee hourlyEmployee, Long id);

    HourlyEmployee updateHourlyEmployeeHourlyRate(BigDecimal hourlyRate, Long id);

    HourlyEmployee updateHourlyEmployeeFullTime(boolean fullTime, Long id);

    void deleteHourlyEmployee(Long id);

}
