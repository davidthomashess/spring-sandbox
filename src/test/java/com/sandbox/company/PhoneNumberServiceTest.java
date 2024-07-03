package com.sandbox.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.sandbox.company.entity.PhoneNumber;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.PhoneNumberRepository;
import com.sandbox.company.service.PhoneNumberServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PhoneNumberServiceTest {

    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private PhoneNumberServiceImpl phoneNumberServiceImpl;

    private Employee[] employees = {
            new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                    "h.golbalt@company.com"),
            new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com") };

    private PhoneNumber[] phoneNumbers = {
            new PhoneNumber(1L, employees[0], "(000) 000-0000", "mobile", false),
            new PhoneNumber(2L, employees[1], "(111) 111-1111", "work", false) };

    @Test
    public void getPhoneNumbersTest() {
        when(phoneNumberServiceImpl.getPhoneNumbers()).thenReturn(Arrays.asList(phoneNumbers));

        List<PhoneNumber> phoneNumbers = phoneNumberServiceImpl.getPhoneNumbers();

        assertEquals("(000) 000-0000", phoneNumbers.get(0).getPhone());
        assertEquals("(111) 111-1111", phoneNumbers.get(1).getPhone());
    }

    @Test
    public void savePhoneNumberTest() {
        when(phoneNumberRepository.save(phoneNumbers[0])).thenReturn(phoneNumbers[0]);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));

        PhoneNumber phoneNumber = phoneNumberServiceImpl.savePhoneNumber(phoneNumbers[0], 1L);

        assertEquals(phoneNumbers[0], phoneNumber);
    }

    @Test
    public void updatePhoneNumberPhoneTest() {
        String phone = "(222) 222-2222";

        when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumbers[0]));
        when(phoneNumberRepository.save(phoneNumbers[0])).thenReturn(phoneNumbers[0]);

        PhoneNumber phoneNumber = phoneNumberServiceImpl.updatePhoneNumberPhone(phone, 1L);

        assertEquals(phone, phoneNumber.getPhone());
    }

    @Test
    public void updatePhoneNumberPhoneTypeTest() {
        String phoneType = "home";

        when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumbers[0]));
        when(phoneNumberRepository.save(phoneNumbers[0])).thenReturn(phoneNumbers[0]);

        PhoneNumber phoneNumber = phoneNumberServiceImpl.updatePhoneNumberPhoneType(phoneType, 1L,
                phoneNumbers[0].getPhone());

        assertEquals(phoneType, phoneNumber.getPhoneType());
    }

    @Test
    public void updatePhoneNumberPhonePrimaryTest() {
        boolean phonePrimary = true;

        when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumbers[0]));
        when(phoneNumberRepository.save(phoneNumbers[0])).thenReturn(phoneNumbers[0]);

        PhoneNumber phoneNumber = phoneNumberServiceImpl.updatePhoneNumberPhonePrimary(phonePrimary, 1L,
                phoneNumbers[0].getPhone());

        assertEquals(phonePrimary, phoneNumber.isPhonePrimary());
    }

    @Test
    public void deletePhoneNumberTest() {
        when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumbers[0]));
        when(phoneNumberRepository.save(phoneNumbers[0])).thenReturn(phoneNumbers[0]);

        phoneNumberServiceImpl.deletePhoneNumber(1L);

        verify(phoneNumberRepository).deleteById(1L);
    }

}
