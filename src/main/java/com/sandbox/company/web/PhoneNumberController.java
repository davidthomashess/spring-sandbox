package com.sandbox.company.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.company.entity.PhoneNumber;
import com.sandbox.company.service.PhoneNumberService;
import com.sandbox.company.update.PhoneNumberPhone;
import com.sandbox.company.update.PhoneNumberPhonePrimary;
import com.sandbox.company.update.PhoneNumberPhoneType;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/phone-number")
public class PhoneNumberController {

    private PhoneNumberService phoneNumberService;

    @GetMapping("/all")
    public ResponseEntity<List<PhoneNumber>> getPhoneNumbers() {
        return new ResponseEntity<>(phoneNumberService.getPhoneNumbers(), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PhoneNumber>> getEmployeePhoneNumbers(@PathVariable Long employeeId) {
        return new ResponseEntity<>(phoneNumberService.getEmployeePhoneNumbers(employeeId), HttpStatus.OK);
    }

    @GetMapping("/{phoneId}")
    public ResponseEntity<PhoneNumber> getPhoneNumber(@PathVariable Long phoneId) {
        return new ResponseEntity<>(phoneNumberService.getPhoneNumber(phoneId), HttpStatus.OK);
    }

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<PhoneNumber> savePhoneNumber(@Valid @RequestBody PhoneNumber phoneNumber,
            @PathVariable Long employeeId) {
        return new ResponseEntity<>(phoneNumberService.savePhoneNumber(phoneNumber, employeeId), HttpStatus.CREATED);
    }

    @PutMapping("/{phoneId}/phone")
    public ResponseEntity<PhoneNumber> updatePhoneNumberPhone(@Valid @RequestBody PhoneNumberPhone phoneNumberPhone,
            @PathVariable Long phoneId) {
        return new ResponseEntity<>(
                phoneNumberService.updatePhoneNumberPhone(phoneNumberPhone.getPhone(), phoneId),
                HttpStatus.OK);
    }

    @PutMapping("/{phoneId}/phone-type")
    public ResponseEntity<PhoneNumber> updatePhoneNumberPhoneType(
            @Valid @RequestBody PhoneNumberPhoneType phoneNumberPhoneType,
            @PathVariable Long phoneId) {
        return new ResponseEntity<>(
                phoneNumberService.updatePhoneNumberPhoneType(phoneNumberPhoneType.getPhoneType(), phoneId,
                        phoneNumberPhoneType.getPhone()),
                HttpStatus.OK);
    }

    @PutMapping("/{phoneId}/phone-primary")
    public ResponseEntity<PhoneNumber> updatePhoneNumberPhonePrimary(
            @Valid @RequestBody PhoneNumberPhonePrimary phoneNumberPrimary,
            @PathVariable Long phoneId) {
        return new ResponseEntity<>(
                phoneNumberService.updatePhoneNumberPhonePrimary(phoneNumberPrimary.isPhonePrimary(), phoneId,
                        phoneNumberPrimary.getPhone()),
                HttpStatus.OK);
    }

    @DeleteMapping("/{phoneId}")
    public ResponseEntity<HttpStatus> deletePhoneNumber(@PathVariable Long phoneId) {
        phoneNumberService.deletePhoneNumber(phoneId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
