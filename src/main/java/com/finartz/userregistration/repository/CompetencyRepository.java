package com.finartz.userregistration.repository;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.finartz.userregistration.entity.Competency;

import java.util.List;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Long>{
    List<Competency> findByEvaluationId(Long evaluationId);
    
} 