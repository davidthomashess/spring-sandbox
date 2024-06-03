package com.sandbox.computershop;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.repository.BrandRepository;
import com.sandbox.computershop.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class ComputerShopApplication implements CommandLineRunner {

    private CustomerRepository customerRepository;
    private BrandRepository brandRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComputerShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer[] customers = new Customer[] {
                new Customer("Sam Fredrick", LocalDate.parse(("1980-07-31"))),
                new Customer("James Durfurther", LocalDate.parse(("1988-12-01"))),
                new Customer("Samantha Koran", LocalDate.parse(("1979-02-23"))),
                new Customer("Louis Jatan", LocalDate.parse(("1993-06-03")))
        };

        for (int i = 0; i < customers.length; i++) {
            customerRepository.save(customers[i]);
        }

        Brand[] brands = new Brand[] {
                new Brand("Toshiba", "Satelite", "Good sized laptop with 12gb memory and 120gb hard drive."),
                new Brand("Asus", "G75VW", "An amazing gaming laptop with exceptional gaming capabilities."),
                new Brand("Apple", "2019 MBP",
                        "Best Unix based laptop for productivity so that you can design graphics, build websites and program amazing applications and APIs."),
                new Brand("Dell", "ALIENWARE",
                        "A powerful gaming laptop that is on par with an alien invasion. Be careful who you use it on."),
                new Brand("HP", "PAVILION",
                        "A nice tablet/laptop combo with a ditigal pen for drawing amazing graphics"),
                new Brand("Razor", "RZ09",
                        "Play the latest AAA titles with the new 12th Gen Intel 14-Core Processor.")
        };

        for (int i = 0; i < brands.length; i++) {
            brandRepository.save(brands[i]);
        }
    }
}