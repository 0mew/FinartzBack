package com.finartz.userregistration.config;


import com.finartz.userregistration.entity.Position;
import com.finartz.userregistration.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PositionIntializer implements CommandLineRunner {

    @Autowired
    private PositionRepository positionRepository;


    @Override
    public void run(String... args) throws Exception {
        if(positionRepository.count()==0)
        {
            positionRepository.save(new Position(1,"Kendisi"));
            positionRepository.save(new Position(2,"Yönetici"));
            positionRepository.save(new Position(3,"Eş Değer"));
            positionRepository.save(new Position(4,"Ast"));
            positionRepository.save(new Position(5,"Diğer"));

        }
    }
}
