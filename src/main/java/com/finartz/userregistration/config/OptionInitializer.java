package com.finartz.userregistration.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.finartz.userregistration.entity.Option;
import com.finartz.userregistration.repository.OptionRepository;


@Component
public class OptionInitializer implements CommandLineRunner{
    @Autowired
    OptionRepository optionRepository;

    @Override
    public void run(String... args) throws Exception {
        if(optionRepository.count() == 0) {
            Option option1 = Option.builder().score(5).option("Üstün başarılı performans").build();
            Option option2 = Option.builder().score(4).option("Çok başarılı performans").build();
            Option option3 = Option.builder().score(3).option("Başarılı performans").build();
            Option option4 = Option.builder().score(2).option("Geliştirilmesi gereken performans").build();
            Option option5 = Option.builder().score(1).option("Yetersiz performans").build();
            Option option6 = Option.builder().score(0).option("Fikrim yok").build();

            optionRepository.saveAll(List.of(option1, option2, option3, option4, option5, option6));
        }
    }
    
}
