package com.finartz.userregistration.config;

import com.finartz.userregistration.entity.Position;
import com.finartz.userregistration.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.repository.UserTitleRepository;

@Component
public class UserTitleInitializer implements CommandLineRunner{
    @Autowired
    private UserTitleRepository userTitleRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userTitleRepository.count() == 0) {
            userTitleRepository.save(new UserTitle(1, "Product Manager"));
            userTitleRepository.save(new UserTitle(2, "Product Manager Intern"));
            userTitleRepository.save(new UserTitle(3, "Backend Developer"));
            userTitleRepository.save(new UserTitle(4, "Backend Developer Intern"));
            userTitleRepository.save(new UserTitle(5, "Frontend Developer"));
            userTitleRepository.save(new UserTitle(6, "Backend Developer Intern"));
            userTitleRepository.save(new UserTitle(7, "Test Engineer"));
            userTitleRepository.save(new UserTitle(8, "Test Engineer Intern"));
            userTitleRepository.save(new UserTitle(9, "DevOps Engineer"));
            userTitleRepository.save(new UserTitle(10, "Lead Product Manager"));
            userTitleRepository.save(new UserTitle(11, "Software Development Director"));
            userTitleRepository.save(new UserTitle(12, "CTBO"));
            userTitleRepository.save(new UserTitle(13, "Software Development Team Lead"));
            userTitleRepository.save(new UserTitle(14, "UI/UX Designer"));
        }

    }

    
    
}
