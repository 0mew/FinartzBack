package com.finartz.userregistration.repository;

import com.finartz.userregistration.entity.EvaluationWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationWeightRepository extends JpaRepository<EvaluationWeight,Integer> {
    List<EvaluationWeight> findByModelId(int modelId);

}
