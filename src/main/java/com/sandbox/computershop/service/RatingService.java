package com.sandbox.computershop.service;

import java.util.List;

import com.sandbox.computershop.entity.Rating;

public interface RatingService {

    List<Rating> getRatings();

    List<Rating> getCustomerRatings(Long customerId);

    List<Rating> getBrandRatings(Long brandId);

    Rating getRating(Long customerId, Long brandId);

    Rating saveRating(Rating rating, Long customerId, Long brandId);

    Rating updateRating(Integer stars, Long customerId, Long brandId);

    void deleteRating(Long customerId, Long brandId);

}
