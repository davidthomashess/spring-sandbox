package com.spring.employment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class EmploymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmploymentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee[] employees = new Employee[] {
                new Employee("Sam Fredrick", LocalDate.parse(("1980-07-31"))),
                new Employee("James Durfurther", LocalDate.parse(("1988-12-01"))),
                new Employee("Samantha Koran", LocalDate.parse(("1979-02-23"))),
                new Employee("Louis Jatan", LocalDate.parse(("1993-06-03")))
        };

        for (int i = 0; i < employees.length; i++) {
            employeeRepository.save(employees[i]);
        }

        Employor[] employers = new Employer[] {
                new Employer("Whataburger", "FOOD",
                        "Specializes in providing fast food drive-in or dine-in services. Hamburgers, fries, and shakes are their specialties."),
                new Employer("Rackspace", "TECH",
                        "Provides hardware infrastructure that allows for hosting and managing a variety of business solutions in the cloud. Also known as the managed cloud."),
                new Employer("HEB", "GROCERY",
                        "Your local Texas chain grocery store serving the families and businesses of Texas since 1905."),
                new Employer("Valero", "OIL",
                        "Crude oil refinement and pipeline transportation. Serves customers at gas pumps and corner stores."),
                new Employer("Accenture Federal Services", "GOV",
                        "Provides government contracting workforce solutions."),
                new Employer("Frost Bank", "BANK", "Banking and financial services.")
        };

        for (int i = 0; i < employers.length; i++) {
            employerRepository.save(courses[i]);
        }
    }
}
