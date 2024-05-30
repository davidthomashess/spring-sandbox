package com.spring.employment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.employment.entity.Employer;
import com.spring.employment.entity.Rating;
import com.spring.employment.entity.Employee;
import com.spring.employment.exception.DeleteException;
import com.spring.employment.exception.RatingNotFoundException;
import com.spring.employment.exception.EmployeeNotEmployedException;
import com.spring.employment.repository.EmployerRepository;
import com.spring.employment.repository.RatingRepository;
import com.spring.employment.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private EmployeeRepository employeeRepository;
    private EmployerRepository employerRepository;

    @Override
    public Rating getRating(Long employeeId, Long employerId) {
        Optional<Rating> rating = ratingRepository.findByEmployeeIdAndEmployerId(employeeId, employerId);

        return unwrapRating(rating, employeeId, employerId);
    }

    @Override
    public Rating saveRating(Rating rating, Long employeeId, Long employerId) {
        Employee employee = EmployeeServiceImpl.unwrapEmployee(employeeRepository.findById(employeeId), employeeId);
        Employer employer = EmployerServiceImpl.unwrapEmployer(employerRepository.findById(employerId), employerId);

        if (!employee.getEmployers().contains(employer))
            throw new EmployeeNotEmployedException(employeeId, employerId);

        rating.setEmployee(employee);
        rating.setEmployer(employer);

        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Integer score, Long employeeId, Long employerId) {
        Optional<Rating> rating = ratingRepository.findByEmployeeIdAndEmployerId(employeeId, employerId);
        Rating unwrappedRating = unwrapRating(rating, employeeId, employerId);

        unwrappedRating.setScore(score);

        return ratingRepository.save(unwrappedRating);
    }

    @Override
    public void deleteRating(Long employeeId, Long employerId) {
        Optional<Rating> rating = ratingRepository.findByEmployeeIdAndEmployerId(employeeId, employerId);

        if (rating.isPresent()) {
            ratingRepository.deleteByEmployeeIdAndEmployerId(employeeId, employerId);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public List<Rating> getEmployeeRatings(Long employeeId) {
        return ratingRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Rating> getEmployerRatings(Long employerId) {
        return ratingRepository.findByEmployerId(employerId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    static Rating unwrapRating(Optional<Rating> entity, Long employeeId, Long employerId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new RatingNotFoundException(employeeId, employerId);
    }

}
