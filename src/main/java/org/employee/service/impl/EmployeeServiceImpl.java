package org.employee.service.impl;

import org.employee.model.dto.EmployeeDto;
import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public EmployeeDto getSingleEmployee(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }
}
