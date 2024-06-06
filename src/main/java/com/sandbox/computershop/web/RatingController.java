package com.sandbox.computershop.web;

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

import com.sandbox.computershop.entity.Rating;
import com.sandbox.computershop.service.RatingService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<>(ratingService.getRatings(), HttpStatus.OK);
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<Rating>> getBrandRatings(@PathVariable Long brandId) {
        return new ResponseEntity<>(ratingService.getBrandRatings(brandId), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Rating>> getCustomerRatings(@PathVariable Long customerId) {
        return new ResponseEntity<>(ratingService.getCustomerRatings(customerId), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/brand/{brandId}")
    public ResponseEntity<Rating> getRating(@PathVariable Long customerId, @PathVariable Long brandId) {
        return new ResponseEntity<>(ratingService.getRating(customerId, brandId), HttpStatus.OK);
    }

    @PostMapping("/customer/{customerId}/brand/{brandId}")
    public ResponseEntity<Rating> saveRating(@Valid @RequestBody Rating rating, @PathVariable Long customerId,
            @PathVariable Long brandId) {
        return new ResponseEntity<>(ratingService.saveRating(rating, customerId, brandId), HttpStatus.CREATED);
    }

    @PutMapping("/customer/{customerId}/brand/{brandId}")
    public ResponseEntity<Rating> updateRating(@Valid @RequestBody Rating rating, @PathVariable Long customerId,
            @PathVariable Long brandId) {
        return new ResponseEntity<>(ratingService.updateRating(rating.getStars(), customerId, brandId), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{customerId}/brand/{brandId}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable Long customerId, @PathVariable Long brandId) {
        ratingService.deleteRating(customerId, brandId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
