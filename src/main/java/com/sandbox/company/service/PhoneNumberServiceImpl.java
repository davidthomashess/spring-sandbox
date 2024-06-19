package com.sandbox.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.PhoneNumber;
import com.sandbox.company.exception.DeleteException;
import com.sandbox.company.exception.EmployeeNotFoundException;
import com.sandbox.company.exception.PhoneNumberNotFoundException;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.PhoneNumberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private EmployeeRepository employeeRepository;
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        return (List<PhoneNumber>) phoneNumberRepository.findAll();
    }

    @Override
    public List<PhoneNumber> getEmployeePhoneNumbers(Long employeeId) {
        return phoneNumberRepository.findByEmployeeId(employeeId);
    }

    @Override
    public PhoneNumber getPhoneNumber(Long phoneId) {
        return phoneNumberRepository.findById(phoneId).get();
    }

    @Override
    public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber, Long employeeId) {
        Employee employee = EmployeeServiceImpl.unwrapEmployee(employeeRepository.findById(employeeId), employeeId);

        if (!employeeRepository.findById(employeeId).isPresent())
            throw new EmployeeNotFoundException(employeeId);

        phoneNumber.setEmployee(employee);

        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public PhoneNumber updatePhoneNumberPhone(String phone, Long phoneId) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneId);
        PhoneNumber unwrappedPhoneNumber = unwrapPhoneNumber(phoneNumber, phone);

        unwrappedPhoneNumber.setPhone(phone);

        return phoneNumberRepository.save(unwrappedPhoneNumber);
    }

    @Override
    public PhoneNumber updatePhoneNumberPhoneType(String phoneType, Long phoneId, String phone) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneId);
        PhoneNumber unwrappedPhoneNumber = unwrapPhoneNumber(phoneNumber, phone);

        unwrappedPhoneNumber.setPhoneType(phoneType);

        return phoneNumberRepository.save(unwrappedPhoneNumber);
    }

    @Override
    public PhoneNumber updatePhoneNumberPhonePrimary(boolean phonePrimary, Long phoneId, String phone) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneId);
        PhoneNumber unwrappedPhoneNumber = unwrapPhoneNumber(phoneNumber, phone);

        unwrappedPhoneNumber.setPhonePrimary(phonePrimary);

        return phoneNumberRepository.save(unwrappedPhoneNumber);
    }

    @Override
    public void deletePhoneNumber(Long phoneId) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneId);

        if (phoneNumber.isPresent())
            phoneNumberRepository.deleteById(phoneId);
        else
            throw new DeleteException();
    }

    static PhoneNumber unwrapPhoneNumber(Optional<PhoneNumber> entity, String phone) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new PhoneNumberNotFoundException(phone);
    }

}
