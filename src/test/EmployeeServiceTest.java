package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee emp = new Employee(1L, "Navya", "navya@gmail.com", "IT");

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(emp));

        List<Employee> result = service.getAllEmployees();

        assertEquals(1, result.size());
        assertEquals("Navya", result.get(0).getName());
    }
}
