package com.sandbox.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.HourlyEmployee;
import com.sandbox.company.exception.DeleteException;
import com.sandbox.company.exception.EmployeeNotFoundException;
import com.sandbox.company.exception.HourlyEmployeeNotFoundException;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.HourlyEmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HourlyEmployeeServiceImpl implements HourlyEmployeeService {

    private EmployeeRepository employeeRepository;
    private HourlyEmployeeRepository hourlyEmployeeRepository;

    @Override
    public List<HourlyEmployee> getHourlyEmployees() {
        return (List<HourlyEmployee>) hourlyEmployeeRepository.findAll();
    }

    @Override
    public HourlyEmployee getHourlyEmployee(Long id) {
        return hourlyEmployeeRepository.findById(id).get();
    }

    @Override
    public HourlyEmployee saveHourlyEmployee(HourlyEmployee hourlyEmployee, Long id) {
        if (!employeeRepository.findById(id).isPresent())
            throw new EmployeeNotFoundException(id);

        hourlyEmployee.setId(id);

        return hourlyEmployeeRepository.save(hourlyEmployee);
    }

    @Override
    public HourlyEmployee updateHourlyEmployeeHourlyRate(double hourlyRate, Long id) {
        Optional<HourlyEmployee> hourlyEmployee = hourlyEmployeeRepository.findById(id);
        HourlyEmployee unwrappedHourlyEmployee = unwrapHourlyEmployee(hourlyEmployee, id);

        unwrappedHourlyEmployee.setHourlyRate(hourlyRate);

        return hourlyEmployeeRepository.save(unwrappedHourlyEmployee);
    }

    @Override
    public HourlyEmployee updateHourlyEmployeeFullTime(boolean fullTime, Long id) {
        Optional<HourlyEmployee> hourlyEmployee = hourlyEmployeeRepository.findById(id);
        HourlyEmployee unwrappedHourlyEmployee = unwrapHourlyEmployee(hourlyEmployee, id);

        unwrappedHourlyEmployee.setFullTime(fullTime);

        return hourlyEmployeeRepository.save(unwrappedHourlyEmployee);
    }

    @Override
    public void deleteHourlyEmployee(Long id) {
        Optional<HourlyEmployee> hourlyEmployee = hourlyEmployeeRepository.findById(id);

        if (hourlyEmployee.isPresent())
            hourlyEmployeeRepository.deleteById(id);
        else
            throw new DeleteException();
    }

    static HourlyEmployee unwrapHourlyEmployee(Optional<HourlyEmployee> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new HourlyEmployeeNotFoundException(id);
    }

}
