package com.finartz.userregistration.controller;
import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.service.EmployeeService;
import com.finartz.userregistration.service.impl.EmployeeExcelImportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    private EmployeeExcelImportServiceImpl excelImportService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest)
    {
        return ResponseEntity.ok(employeeService.saveEmployee(createEmployeeRequest));
    }
    @PutMapping("/deactive/{employeeId}")
    public ResponseEntity<Employee> employeeDeactivee(@PathVariable int employeeId){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeDeactivee(employeeId));
    }

    @PutMapping("/active/{employeeId}")
    public ResponseEntity<Employee> employeeActivee(@PathVariable int employeeId){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeActivee(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping("/import")
    public ResponseEntity<List<Employee>> importEmployees(@RequestParam("file") MultipartFile file) {
        try {
            List<Employee> employees = excelImportService.importEmployees(file);
            return ResponseEntity.ok(employees);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }






}


