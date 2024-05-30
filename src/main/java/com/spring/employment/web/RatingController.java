package com.spring.employment.web;

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

import com.spring.employment.entity.Rating;
import com.spring.employment.service.RatingService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    @GetMapping("/employee/{employeeId}/employer/{employerId}")
    public ResponseEntity<Rating> getRating(@PathVariable Long employeeId, @PathVariable Long employerId) {
        return new ResponseEntity<>(ratingService.getRating(employeeId, employerId), HttpStatus.OK);
    }

    @PostMapping("/employee/{employeeId}/employer/{employerId}")
    public ResponseEntity<Rating> saveRating(@Valid @RequestBody Rating rating, @PathVariable Long employeeId,
            @PathVariable Long employerId) {
        return new ResponseEntity<>(ratingService.saveRating(rating, employeeId, employerId), HttpStatus.CREATED);
    }

    @PutMapping("/employee/{employeeId}/employer/{employerId}")
    public ResponseEntity<Rating> updateRating(@Valid @RequestBody Rating rating, @PathVariable Long employeeId,
            @PathVariable Long employerId) {
        return new ResponseEntity<>(ratingService.updateRating(rating.setScore(), employeeId, employerId),
                HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}/employer/{employerId}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable Long employeeId, @PathVariable Long employerId) {
        ratingService.deleteRating(employeeId, employerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Rating>> getEmployeeRatings(@PathVariable Long employeeId) {
        return new ResponseEntity<>(ratingService.getEmployeeRatings(employeeId), HttpStatus.OK);
    }

    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<Rating>> getEmployerRatings(@PathVariable Long employerId) {
        return new ResponseEntity<>(ratingService.getEmployerRatings(employerId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);
    }

}
