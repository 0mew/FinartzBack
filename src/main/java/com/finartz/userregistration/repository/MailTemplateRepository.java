package com.finartz.userregistration.repository;

import com.finartz.userregistration.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailTemplateRepository extends JpaRepository<MailTemplate,Long> {
    MailTemplate findByid(Long id);
    MailTemplate getByTitle(String title);
    MailTemplate getBydescription(String description);
}
