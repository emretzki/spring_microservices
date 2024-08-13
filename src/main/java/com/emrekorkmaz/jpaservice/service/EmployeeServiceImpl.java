package com.emrekorkmaz.jpaservice.service;

import com.emrekorkmaz.jpaservice.dto.EmployeeDto;
import com.emrekorkmaz.jpaservice.entities.Employee;
import com.emrekorkmaz.jpaservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee=employeeRepository.save(employee);
        employeeDto=modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {

        //Course Material
        /*Employee employee=employeeRepository.findById(employeeDto.getId()).orElseThrow(()-> new IllegalArgumentException("No such employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setAge(employeeDto.getAge());
        employee=employeeRepository.save(employee);
        employeeDto=modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;*/


        //Best Practice
        Employee existingEmployee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        // Map the fields from the employeeDto to the existingEmployee
        modelMapper.map(employeeDto, existingEmployee);

        // Save the updated employee
        existingEmployee = employeeRepository.save(existingEmployee);

        // Map the updated employee back to the employeeDto
        return modelMapper.map(existingEmployee, EmployeeDto.class);
    }


    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> dtoList= employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public EmployeeDto getById(String Id) {
        Employee employee = employeeRepository.findById(Id).orElseThrow(()->new IllegalArgumentException("Employee not found"));
        EmployeeDto dto = modelMapper.map(employee,EmployeeDto.class);
        return dto;
    }

    @Override
    public EmployeeDto delete(String Id) {
        Employee employee = employeeRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        //employeeRepository.delete(employee);
        employeeRepository.deleteById(Id);
        /*Delete List
        List<Employee> list = employeeRepository.findAll();
        employeeRepository.deleteAll(list);*/
        return employeeDto;
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public Page<EmployeeDto> findPagination(int pageSize, int pageNo, String sortField, String sortDirection) {
        return null;
    }

}
