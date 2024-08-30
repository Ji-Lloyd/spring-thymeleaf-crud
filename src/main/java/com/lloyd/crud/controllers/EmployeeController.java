package com.lloyd.crud.controllers;


import com.lloyd.crud.models.Designation;
import com.lloyd.crud.models.Employee;
import com.lloyd.crud.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String employeeList(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("designations", employeeService.getAllDesignations());
        model.addAttribute("employee", new Employee());
        return "home";
    }


    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/delete/{employeeId}")
    public String removeEmployeeById(@PathVariable(value = "employeeId") int employeeId){
        employeeService.removeEmployeeById(employeeId);
        return "redirect:/";
    }

    @GetMapping("/retrieveEmployee/{employeeId}")
    @ResponseBody
    public Employee retrieveEmployee(@PathVariable(value = "employeeId") int employeeId) {
        return employeeService.getEmployeeId(employeeId);
    }

    @PostMapping("/employee/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }



}
