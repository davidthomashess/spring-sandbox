package com.sandbox.company.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.Project;
import com.sandbox.company.exception.ProjectNotFoundException;
import com.sandbox.company.repository.ProjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProjectName(String name, Long id) {
        Optional<Project> project = projectRepository.findById(id);
        Project unwrappedProject = unwrapProject(project, id);

        unwrappedProject.setName(name);

        return projectRepository.save(unwrappedProject);
    }

    @Override
    public Project updateProjectDescription(String description, Long id) {
        Optional<Project> project = projectRepository.findById(id);
        Project unwrappedProject = unwrapProject(project, id);

        unwrappedProject.setDescription(description);

        return projectRepository.save(unwrappedProject);
    }

    @Override
    public Project updateProjectStartDate(LocalDate startDate, Long id) {
        Optional<Project> project = projectRepository.findById(id);
        Project unwrappedProject = unwrapProject(project, id);

        unwrappedProject.setStartDate(startDate);

        return projectRepository.save(unwrappedProject);
    }

    @Override
    public Project updateProjectEndDate(LocalDate endDate, Long id) {
        Optional<Project> project = projectRepository.findById(id);
        Project unwrappedProject = unwrapProject(project, id);

        unwrappedProject.setEndDate(endDate);

        return projectRepository.save(unwrappedProject);
    }

    static Project unwrapProject(Optional<Project> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new ProjectNotFoundException(id);
    }

}
