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
import com.sandbox.company.entity.SalaryEmployee;
import com.sandbox.company.entity.PhoneNumber;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.SalaryEmployeeRepository;
import com.sandbox.company.service.EmployeeServiceImpl;
import com.sandbox.company.service.SalaryEmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SalaryEmployeeTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Mock
    private SalaryEmployeeRepository salaryEmployeeRepository;

    @InjectMocks
    private SalaryEmployeeServiceImpl salaryEmployeeServiceImpl;

    private Employee[] employees = {
            new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                    "h.golbalt@company.com"),
            new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com") };

    private SalaryEmployee[] salaryEmployees = {
            new SalaryEmployee(employees[0], new BigDecimal(89993.23), true),
            new SalaryEmployee(employees[1], new BigDecimal(53234.01), false)
    };

    @Test
    public void getSalaryEmployeesTest() {
        when(salaryEmployeeServiceImpl.getSalaryEmployees()).thenReturn(Arrays.asList(salaryEmployees));

        List<SalaryEmployee> salaryEmployees = salaryEmployeeServiceImpl.getSalaryEmployees();

        assertEquals(true, salaryEmployees.get(0).isFullTime());
        assertEquals(false, salaryEmployees.get(1).isFullTime());
    }

    @Test
    public void getSalaryEmployeeTest() {
        when(salaryEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(salaryEmployees[0]));

        SalaryEmployee salaryEmployee = salaryEmployeeServiceImpl.getSalaryEmployee(1L);

        assertEquals(salaryEmployees[0], salaryEmployee);
    }

    @Test
    public void saveSalaryEmployeeTest() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(salaryEmployeeRepository.save(salaryEmployees[0])).thenReturn(salaryEmployees[0]);

        SalaryEmployee salaryEmployee = salaryEmployeeServiceImpl.saveSalaryEmployee(salaryEmployees[0], 1L);

        verify(salaryEmployeeRepository, times(1)).save(salaryEmployee);
        assertEquals(salaryEmployees[0], salaryEmployee);
    }

    @Test
    public void updateSalaryEmployeeSalaryRateTest() {
        BigDecimal salaryRate = new BigDecimal(10200.03);

        when(salaryEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(salaryEmployees[0]));
        when(salaryEmployeeRepository.save(salaryEmployees[0])).thenReturn(salaryEmployees[0]);

        SalaryEmployee salaryEmployee = salaryEmployeeServiceImpl.updateSalaryEmployeeSalaryRate(salaryRate, 1L);

        assertEquals(salaryRate, salaryEmployee.getSalaryRate());
    }

    @Test
    public void updateSalaryEmployeeFullTimeTest() {
        boolean fullTime = false;

        when(salaryEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(salaryEmployees[0]));
        when(salaryEmployeeRepository.save(salaryEmployees[0])).thenReturn(salaryEmployees[0]);

        SalaryEmployee salaryEmployee = salaryEmployeeServiceImpl.updateSalaryEmployeeFullTime(fullTime, 1L);

        assertEquals(fullTime, salaryEmployee.isFullTime());
    }

    @Test
    public void deletePhoneNumberTest() {
        when(salaryEmployeeRepository.findByEmployeeId(1L)).thenReturn(Optional.of(salaryEmployees[0]));
        when(salaryEmployeeRepository.save(salaryEmployees[0])).thenReturn(salaryEmployees[0]);

        salaryEmployeeServiceImpl.deleteSalaryEmployee(1L);

        verify(salaryEmployeeRepository).deleteByEmployeeId(1L);
    }

}
