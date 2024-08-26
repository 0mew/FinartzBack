package com.finartz.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    
}
