package com.finartz.userregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    List<Question> findByCompetencyId(Long competencyId);
}
