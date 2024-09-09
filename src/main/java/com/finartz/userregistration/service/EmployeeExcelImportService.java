package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeExcelImportService {
    public List<Employee> importEmployees(MultipartFile file) throws IOException;
}
