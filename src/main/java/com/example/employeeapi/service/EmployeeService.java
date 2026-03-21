package com.example.employeeapi.service;

import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ✅ Logging imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // ✅ Logger
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    // ✅ GET ALL
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return repository.findAll();
    }

    // ✅ GET BY ID
    public Employee getEmployeeById(Long id) {
        logger.info("Fetching employee with id: {}", id);
        return repository.findById(id).orElse(null);
    }

    // ✅ CREATE
    public Employee saveEmployee(Employee employee) {
        logger.info("Saving employee: {}", employee.getName());
        return repository.save(employee);
    }

    // ✅ UPDATE
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        logger.info("Updating employee with id: {}", id);

        Employee employee = repository.findById(id).orElse(null);

        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());

            logger.info("Employee updated successfully");
            return repository.save(employee);
        }

        logger.warn("Employee not found with id: {}", id);
        return null;
    }

    // ✅ DELETE
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with id: {}", id);
        repository.deleteById(id);
    }
}