package com.lloyd.crud.services;

import com.lloyd.crud.models.Designation;
import com.lloyd.crud.models.Employee;
import com.lloyd.crud.repositories.DesignationDao;
import com.lloyd.crud.repositories.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeDao employeeDao;
    DesignationDao designationDao;

    public EmployeeService(EmployeeDao employeeDao, DesignationDao designationDao) {
        this.employeeDao = employeeDao;
        this.designationDao = designationDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public List<Designation> getAllDesignations() {
        return designationDao.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void removeEmployeeById(int employeeId) {
        employeeDao.deleteById(employeeId);
    }

    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new RuntimeException(" Employee not found for id :: " + employeeId);
        }
    }

    public void updateEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getEmployeeId(int employeeId) {
        return employeeDao.findById(employeeId).get();
    }
}
