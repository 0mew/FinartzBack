package com.finartz.userregistration.repository;

import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.UserTitle;


@Repository
public interface UserTitleRepository extends JpaRepository<UserTitle, Integer>{
    UserTitle getByTitle(String title);
    
}
