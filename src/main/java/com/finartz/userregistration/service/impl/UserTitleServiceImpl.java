package com.finartz.userregistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.repository.UserTitleRepository;
import com.finartz.userregistration.service.UserTitleService;


@Service
public class UserTitleServiceImpl implements UserTitleService{
    @Autowired
    private UserTitleRepository userTitleRepository;

    @Override
    public UserTitle createUserTitle(String title) {
        UserTitle userTitle = UserTitle.builder().title(title).build();
        return userTitleRepository.save(userTitle);
    }
    public List<UserTitle> getAllUserTitles(){
        return userTitleRepository.findAll();
    }
}
