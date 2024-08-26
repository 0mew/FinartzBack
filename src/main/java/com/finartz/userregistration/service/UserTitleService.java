package com.finartz.userregistration.service;

import java.util.List;

import com.finartz.userregistration.entity.UserTitle;

public interface UserTitleService {
    UserTitle createUserTitle(String title);
    List<UserTitle> getAllUserTitles();
}
