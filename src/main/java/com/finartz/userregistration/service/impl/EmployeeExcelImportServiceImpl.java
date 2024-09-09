package com.finartz.userregistration.service.impl;

import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.EmployeeRepository;
import com.finartz.userregistration.repository.UserTitleRepository;
import com.finartz.userregistration.service.EmployeeExcelImportService;
import com.finartz.userregistration.service.EmployeeService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 @Service
public class EmployeeExcelImportServiceImpl implements EmployeeExcelImportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserTitleRepository userTitleRepository;


     @Override
     public List<Employee> importEmployees(MultipartFile file) throws IOException {
         List<Employee> employees = new ArrayList<>();
         try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
             Sheet sheet = workbook.getSheetAt(0);
             Iterator<Row> rows = sheet.iterator();

             boolean headerRow = true;
             while (rows.hasNext()) {
                 Row currentRow = rows.next();

                 // Skip header row
                 if (headerRow) {
                     headerRow = false;
                     continue;
                 }

                 // Check if the cell is null and assign default values if necessary
                 String firstName = currentRow.getCell(0) != null ? currentRow.getCell(0).getStringCellValue() : "";
                 String lastName = currentRow.getCell(1) != null ? currentRow.getCell(1).getStringCellValue() : "";
                 String email = currentRow.getCell(2) != null ? currentRow.getCell(2).getStringCellValue() : "";
                 String title = currentRow.getCell(3) != null ? currentRow.getCell(3).getStringCellValue() : "";

                 if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || title.isEmpty()) {
                     // Skip rows with empty mandatory fields
                     continue;
                 }

                 // Fetch UserTitle entity from the database
                 UserTitle userTitle = userTitleRepository.getByTitle(title);
                 if (userTitle == null) {
                     throw new ResourceNotFoundException("UserTitle not found: " + title);
                 }

                 Employee employee = Employee.builder()
                         .firstName(firstName)
                         .lastName(lastName)
                         .email(email)
                         .userTitle(userTitle)
                         .active(true)
                         .build();

                 employees.add(employee);
             }
         }

         return employeeRepository.saveAll(employees);
     }
}
