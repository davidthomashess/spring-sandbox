package com.spring.employment.service;

import java.util.List;

import com.spring.employment.entity.Rating;

public interface RatingService {

    Rating getRating(Long employeeId, Long employerId);

    Rating saveRating(Rating rating, Long employeeId, Long employerId);

    Rating updateRating(Integer score, Long employeeId, Long employerId);

    void deleteRating(Long employeeId, Long employerId);

    List<Rating> getEmployeeRatings(Long employeeId);

    List<Rating> getEmployerRatings(Long employerId);

    List<Rating> getAllRatings();

}
