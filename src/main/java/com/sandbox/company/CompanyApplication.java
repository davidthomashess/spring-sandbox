package com.sandbox.company;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.Project;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.ProjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class CompanyApplication implements CommandLineRunner {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee[] employee = new Employee[] {
                new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                        "h.golbalt@company.com"),
                new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com"),
                new Employee("Ronald", "Ustnik", "12643 Twelth Ave", "Beat", "Texas", "r.ustnik@company.com"),
                new Employee("Subaru", "Natsuki", "4 Emilia Tan", "Mathers Domain Entrance", "Alaska",
                        "s.natsuki@company.com"),
                new Employee("Ken", "Hustle", "1 Top Hustler", "Highest", "Calafornia", "k.hustler@company.com")
        };

        Project[] project = new Project[] {
                new Project("Chess App", "Make an app that can play chess", LocalDate.of(2018, Month.FEBRUARY, 27),
                        LocalDate.of(2019, Month.MARCH, 17)),
                new Project("Chess App", "Make an app that can play chess", LocalDate.of(2022, Month.JULY, 9),
                        LocalDate.of(2022, Month.DECEMBER, 10)),
                new Project("Chess App", "Make an app that can play chess", LocalDate.of(2024, Month.APRIL, 22),
                        LocalDate.of(2025, Month.FEBRUARY, 2))
        };

        for (int i = 0; i < employee.length; i++) {
            employeeRepository.save(employee[i]);
        }

        for (int i = 0; i < project.length; i++) {
            projectRepository.save(project[i]);
        }
    }

}
