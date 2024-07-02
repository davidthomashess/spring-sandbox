package com.sandbox.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    private Employee[] employees = {
            new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                    "h.golbalt@company.com"),
            new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com") };

    @Test
    public void getEmployeesTest() {
        when(employeeServiceImpl.getEmployees()).thenReturn(Arrays.asList(employees));

        List<Employee> employees = employeeServiceImpl.getEmployees();

        assertEquals("Henry", employees.get(0).getFirstName());
        assertEquals("Keys", employees.get(1).getLastName());
    }

    @Test
    public void getEmployeeTest() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));

        Employee employee = employeeServiceImpl.getEmployee(1L);

        assertEquals(employees[0], employee);
    }

    @Test
    public void saveEmployeeTest() {
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.saveEmployee(employees[0]);

        verify(employeeRepository, times(1)).save(employee);
        assertEquals(employees[0], employee);
    }

    @Test
    public void updateEmployeeFirstNameTest() {
        String firstName = "Mark";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeFirstName(firstName, 1L);

        assertEquals(firstName, employee.getFirstName());
    }

    @Test
    public void updateEmployeeLastNameTest() {
        String lastName = "Smith";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeLastName(lastName, 1L);

        assertEquals(lastName, employee.getLastName());
    }

    @Test
    public void updateEmployeeAddressTest() {
        String address = "1234 I-990 Fake Loop";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeAddress(address, 1L);

        assertEquals(address, employee.getAddress());
    }

    @Test
    public void updateEmployeeCityTest() {
        String city = "Lost Town";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeCity(city, 1L);

        assertEquals(city, employee.getCity());
    }

    @Test
    public void updateEmployeeStateTest() {
        String state = "Florida";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeState(state, 1L);

        assertEquals(state, employee.getState());
    }

    @Test
    public void updateEmployeeEmailTest() {
        String email = "newEmail@example.com";

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        Employee employee = employeeServiceImpl.updateEmployeeEmail(email, 1L);

        assertEquals(email, employee.getEmail());
    }

    @Test
    public void deleteEmployeeEmailTest() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(employeeRepository.save(employees[0])).thenReturn(employees[0]);

        employeeServiceImpl.deleteEmployee(1L);

        verify(employeeRepository).deleteById(1L);
    }
}
