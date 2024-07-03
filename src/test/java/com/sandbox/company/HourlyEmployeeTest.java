package com.sandbox.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.HourlyEmployee;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.HourlyEmployeeRepository;
import com.sandbox.company.service.EmployeeServiceImpl;
import com.sandbox.company.service.HourlyEmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HourlyEmployeeTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Mock
    private HourlyEmployeeRepository hourlyEmployeeRepository;

    @InjectMocks
    private HourlyEmployeeServiceImpl hourlyEmployeeServiceImpl;

    private Employee[] employees = {
            new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                    "h.golbalt@company.com"),
            new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com") };

    private HourlyEmployee[] hourlyEmployees = {
            new HourlyEmployee(employees[0], new BigDecimal(23.23), true),
            new HourlyEmployee(employees[1], new BigDecimal(66.01), false)
    };

    @Test
    public void getHourlyEmployeesTest() {
        when(hourlyEmployeeServiceImpl.getHourlyEmployees()).thenReturn(Arrays.asList(hourlyEmployees));

        List<HourlyEmployee> hourlyEmployees = hourlyEmployeeServiceImpl.getHourlyEmployees();

        assertEquals(true, hourlyEmployees.get(0).isFullTime());
        assertEquals(false, hourlyEmployees.get(1).isFullTime());
    }

    @Test
    public void getHourlyEmployeeTest() {
        when(hourlyEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(hourlyEmployees[0]));

        HourlyEmployee hourlyEmployee = hourlyEmployeeServiceImpl.getHourlyEmployee(1L);

        assertEquals(hourlyEmployees[0], hourlyEmployee);
    }

    @Test
    public void saveHourlyEmployeeTest() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(hourlyEmployeeRepository.save(hourlyEmployees[0])).thenReturn(hourlyEmployees[0]);

        HourlyEmployee hourlyEmployee = hourlyEmployeeServiceImpl.saveHourlyEmployee(hourlyEmployees[0], 1L);

        verify(hourlyEmployeeRepository, times(1)).save(hourlyEmployee);
        assertEquals(hourlyEmployees[0], hourlyEmployee);
    }

    @Test
    public void updateHourlyEmployeeHourlyRateTest() {
        BigDecimal hourlyRate = new BigDecimal(99.99);

        when(hourlyEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(hourlyEmployees[0]));
        when(hourlyEmployeeRepository.save(hourlyEmployees[0])).thenReturn(hourlyEmployees[0]);

        HourlyEmployee hourlyEmployee = hourlyEmployeeServiceImpl.updateHourlyEmployeeHourlyRate(hourlyRate, 1L);

        assertEquals(hourlyRate, hourlyEmployee.getHourlyRate());
    }

    @Test
    public void updateHourlyEmployeeFullTimeTest() {
        boolean fullTime = false;

        when(hourlyEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(hourlyEmployees[0]));
        when(hourlyEmployeeRepository.save(hourlyEmployees[0])).thenReturn(hourlyEmployees[0]);

        HourlyEmployee hourlyEmployee = hourlyEmployeeServiceImpl.updateHourlyEmployeeFullTime(fullTime, 1L);

        assertEquals(fullTime, hourlyEmployee.isFullTime());
    }

    @Test
    public void deletePhoneNumberTest() {
        when(hourlyEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(hourlyEmployees[0]));
        when(hourlyEmployeeRepository.save(hourlyEmployees[0])).thenReturn(hourlyEmployees[0]);

        hourlyEmployeeServiceImpl.deleteHourlyEmployee(1L);

        verify(hourlyEmployeeRepository).deleteByEmployeeId(1L);
    }

}
