package com.finartz.userregistration.config;

import com.finartz.userregistration.entity.Model;
import com.finartz.userregistration.entity.Position;
import com.finartz.userregistration.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ModelIntializer  implements CommandLineRunner {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public void run(String... args) throws Exception {
        if (modelRepository.count()==0)
        {


            for (int i=1;i<=31;i++)
            {
                modelRepository.save(new Model(i,"Model"+i));
            }

        }
    }
}
