package com.sandbox.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sandbox.company.entity.Assignment;
import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.Project;
import com.sandbox.company.repository.AssignmentRepository;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.ProjectRepository;
import com.sandbox.company.service.AssignmentServiceImpl;
import com.sandbox.company.service.EmployeeServiceImpl;
import com.sandbox.company.service.ProjectServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {

    @Mock
    private AssignmentRepository assignmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private AssignmentServiceImpl assignmentServiceImpl;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    private ProjectServiceImpl projectServiceImpl;

    private Employee[] employees = {
            new Employee("Henry", "Golbalt", "23 Some Madeup Address", "Thrillings", "South Dakota",
                    "h.golbalt@company.com"),
            new Employee("Malory", "Keys", "123 Another Fake St", "Guilded", "Vermont", "m.keys@company.com") };

    private Project[] projects = {
            new Project("Chess App", "Make an app that can play chess", LocalDate.of(2018, Month.FEBRUARY, 27),
                    LocalDate.of(2019, Month.MARCH, 17)),
            new Project("Tip Calculator", "Make an app that can calculate tips", LocalDate.of(2022, Month.JULY, 9),
                    LocalDate.of(2022, Month.DECEMBER, 10)) };

    private Assignment[] assignments = {
            new Assignment(employees[0], projects[0], LocalDate.of(2023, Month.APRIL, 28)),
            new Assignment(employees[1], projects[1], LocalDate.of(2024, Month.MARCH, 2))
    };

    @Test
    public void getAssignmentsTest() {
        when(assignmentServiceImpl.getAssignments()).thenReturn(Arrays.asList(assignments));

        List<Assignment> assignments = assignmentServiceImpl.getAssignments();

        assertEquals(LocalDate.of(2023, Month.APRIL, 28), assignments.get(0).getAssignmentDate());
        assertEquals(LocalDate.of(2024, Month.MARCH, 2), assignments.get(1).getAssignmentDate());
    }

    @Test
    public void saveAndGetAssignmentTest() {
        when(assignmentRepository.save(assignments[0])).thenReturn(assignments[0]);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));

        Assignment assignment = assignmentServiceImpl.saveAssignment(assignments[0].getAssignmentDate(), 1L, 1L);

        verify(assignmentRepository, times(1)).save(assignment);
        assertEquals(assignments[0], assignment);
    }

    // Fix deleteAssignmentTest()

    // @Test
    // public void deleteAssignmentTest() {
    // when(employeeRepository.findById(1L)).thenReturn(Optional.of(employees[0]));
    // when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));
    // when(assignmentRepository.save(assignments[0])).thenReturn(assignments[0]);

    // assignmentServiceImpl.deleteAssignment(1L, 1L);

    // verify(assignmentRepository).deleteByEmployeeIdAndProjectId(1L, 1L);
    // }
}
