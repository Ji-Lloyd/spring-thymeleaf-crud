package com.lloyd.crud.services;

import com.lloyd.crud.models.Employee;
import com.lloyd.crud.repositories.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRestApiService {

    EmployeeDao employeeDao;

    public EmployeeRestApiService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDao.findById(employeeId).get();
    }

    public void removeEmployeeById(int employeeId) {
        employeeDao.deleteById(employeeId);
    }
}
