package com.sandbox.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
