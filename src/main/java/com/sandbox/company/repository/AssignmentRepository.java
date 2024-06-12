package com.sandbox.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.Assignment;
import com.sandbox.company.entity.AssignmentPK;

import jakarta.transaction.Transactional;

public interface AssignmentRepository extends CrudRepository<Assignment, AssignmentPK> {

    Optional<Assignment> findByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    @Transactional
    void deleteByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    List<Assignment> findByEmployeeId(Long employeeId);

}
