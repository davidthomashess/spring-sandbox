package com.sandbox.company.service;

import java.time.LocalDate;
import java.util.List;

import com.sandbox.company.entity.Project;

public interface ProjectService {

    List<Project> getProjects();

    Project getProject(Long id);

    Project saveProject(Project project);

    Project updateProjectName(String name, Long id);

    Project updateProjectDescription(String description, Long id);

    Project updateProjectStartDate(LocalDate startDate, Long id);

    Project updateProjectEndDate(LocalDate endDate, Long id);

}
