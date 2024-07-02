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

import com.sandbox.company.entity.Project;
import com.sandbox.company.repository.ProjectRepository;
import com.sandbox.company.service.ProjectServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectServiceImpl;

    Project[] projects = new Project[] {
            new Project("Chess App", "Make an app that can play chess", LocalDate.of(2018, Month.FEBRUARY, 27),
                    LocalDate.of(2019, Month.MARCH, 17)),
            new Project("Tip Calculator", "Make an app that can calculate tips", LocalDate.of(2022, Month.JULY, 9),
                    LocalDate.of(2022, Month.DECEMBER, 10))
    };

    @Test
    public void getProjectsTest() {
        when(projectServiceImpl.getProjects()).thenReturn(Arrays.asList(projects));

        List<Project> projects = projectServiceImpl.getProjects();

        assertEquals("Chess App", projects.get(0).getName());
        assertEquals("Make an app that can calculate tips", projects.get(1).getDescription());
    }

    @Test
    public void getProjectTest() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));

        Project project = projectServiceImpl.getProject(1L);

        assertEquals(projects[0], project);
    }

    @Test
    public void saveProjectTest() {
        when(projectRepository.save(projects[0])).thenReturn(projects[0]);

        Project project = projectServiceImpl.saveProject(projects[0]);

        verify(projectRepository, times(1)).save(project);
        assertEquals(projects[0], project);
    }

    @Test
    public void updateProjectNameTest() {
        String name = "Checkers App";

        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));
        when(projectRepository.save(projects[0])).thenReturn(projects[0]);

        Project project = projectServiceImpl.updateProjectName(name, 1L);

        assertEquals(name, project.getName());
    }

    @Test
    public void updateProjectDescriptionTest() {
        String description = "Checkers App";

        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));
        when(projectRepository.save(projects[0])).thenReturn(projects[0]);

        Project project = projectServiceImpl.updateProjectDescription(description, 1L);

        assertEquals(description, project.getDescription());
    }

    @Test
    public void updateProjectStartDateTest() {
        LocalDate startDate = LocalDate.of(2018, Month.MARCH, 17);

        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));
        when(projectRepository.save(projects[0])).thenReturn(projects[0]);

        Project project = projectServiceImpl.updateProjectStartDate(startDate, 1L);

        assertEquals(startDate, project.getStartDate());
    }

    @Test
    public void updateProjectEndDateTest() {
        LocalDate endDate = LocalDate.of(2019, Month.APRIL, 28);

        when(projectRepository.findById(1L)).thenReturn(Optional.of(projects[0]));
        when(projectRepository.save(projects[0])).thenReturn(projects[0]);

        Project project = projectServiceImpl.updateProjectEndDate(endDate, 1L);

        assertEquals(endDate, project.getEndDate());
    }
}
