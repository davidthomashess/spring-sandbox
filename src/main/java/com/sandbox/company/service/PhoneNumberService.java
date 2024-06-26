package com.sandbox.company.service;

import java.util.List;

import com.sandbox.company.entity.PhoneNumber;

public interface PhoneNumberService {

    List<PhoneNumber> getPhoneNumbers();

    List<PhoneNumber> getEmployeePhoneNumbers(Long employeeId);

    PhoneNumber getPhoneNumber(Long phoneId);

    PhoneNumber savePhoneNumber(PhoneNumber phoneNumber, Long employeeId);

    PhoneNumber updatePhoneNumberPhone(String phone, Long phoneId);

    PhoneNumber updatePhoneNumberPhoneType(String phoneType, Long phoneId, String phone);

    PhoneNumber updatePhoneNumberPhonePrimary(boolean phonePrimary, Long phoneId, String phone);

    void deletePhoneNumber(Long phoneId);

}
