package com.lloyd.crud.controllers;

import com.lloyd.crud.models.Employee;
import com.lloyd.crud.services.EmployeeRestApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestApiController {

    EmployeeRestApiService apiService;

    public EmployeeRestApiController(EmployeeRestApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/v1/employees/all")
    public List<Employee> getAllEmployees(){
        return apiService.getAllEmployees();
    }

    @PostMapping("/v1/employees/add")
    public void saveEmployee(@RequestBody Employee employee){
        apiService.saveEmployee(employee);
    }

    @GetMapping("/v1/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return apiService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/v1/employees/{employeeId}")
    public void removeEmployeeById(@PathVariable int employeeId){
        apiService.removeEmployeeById(employeeId);
    }
}
