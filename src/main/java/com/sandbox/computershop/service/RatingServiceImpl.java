package com.sandbox.computershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.entity.Rating;
import com.sandbox.computershop.exception.CustomerWithoutBrandException;
import com.sandbox.computershop.exception.DeleteException;
import com.sandbox.computershop.exception.RatingNotFoundException;
import com.sandbox.computershop.repository.BrandRepository;
import com.sandbox.computershop.repository.CustomerRepository;
import com.sandbox.computershop.repository.RatingRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {
    private BrandRepository brandRepository;
    private CustomerRepository customerRepository;
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    @Override
    public List<Rating> getBrandRatings(Long brandId) {
        return ratingRepository.findByBrandId(brandId);
    }

    @Override
    public List<Rating> getCustomerRatings(Long customerId) {
        return ratingRepository.findByCustomerId(customerId);
    }

    @Override
    public Rating getRating(Long customerId, Long brandId) {
        Optional<Rating> rating = ratingRepository.findByCustomerIdAndBrandId(customerId, brandId);

        return unwrapRating(rating, customerId, brandId);
    }

    @Override
    public Rating saveRating(Rating rating, Long customerId, Long brandId) {
        Customer customer = CustomerServiceImpl.unwrapCustomer(customerRepository.findById(customerId), customerId);
        Brand brand = BrandServiceImpl.unwrapBrand(brandRepository.findById(brandId), brandId);

        if (!customer.getBrands().contains(brand))
            throw new CustomerWithoutBrandException(customerId, brandId);

        rating.setCustomer(customer);
        rating.setBrand(brand);

        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Integer stars, Long customerId, Long brandId) {
        Optional<Rating> rating = ratingRepository.findByCustomerIdAndBrandId(customerId, brandId);
        Rating unwrappedRating = unwrapRating(rating, customerId, brandId);

        unwrappedRating.setStars(stars);

        return ratingRepository.save(unwrappedRating);
    }

    @Override
    public void deleteRating(Long customerId, Long brandId) {
        Optional<Rating> rating = ratingRepository.findByCustomerIdAndBrandId(customerId, brandId);

        if (rating.isPresent()) {
            ratingRepository.deleteByCustomerIdAndBrandId(customerId, brandId);
        } else {
            throw new DeleteException();
        }
    }

    static Rating unwrapRating(Optional<Rating> entity, Long customerId, Long brandId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new RatingNotFoundException(customerId, brandId);
    }

}