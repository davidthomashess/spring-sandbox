package com.spring.employment.exception;

public class RatingNotFoundException extends RuntimeException {

    public RatingNotFoundException(Long employeeId, Long employerId) {
        super("The rating with employee id: '" + employeeId + "' and employer id: '" + employerId
                + "' does not exist in our records");
    }

}
