package org.employee.service.impl;

import org.employee.model.dto.EmployeeDto;
import org.employee.model.entity.Employee;
import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        if(employeeDto.getId() != null){
            throw new RuntimeException("Employee already exists");
        }
        Employee entity = modelMapper.map(employeeDto, Employee.class);
        Employee savedEntity = employeeRepository.save(entity);
        return modelMapper.map(savedEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        if(id == null || employeeDto.getId() == null){
            throw new RuntimeException(" Please provide employee id!!");
        }

        if(!Objects.equals(id, employeeDto.getId())){
            throw new RuntimeException("Id mismatch");
        }

        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));

        Employee entity = modelMapper.map(employeeDto, Employee.class);
        Employee updatedEmployee = employeeRepository.save(entity);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto getSingleEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
        return modelMapper.map(employee, EmployeeDto.class) ;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class)).toList();

    }
}
