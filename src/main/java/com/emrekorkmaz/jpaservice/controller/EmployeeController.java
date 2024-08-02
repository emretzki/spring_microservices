package com.emrekorkmaz.jpaservice.controller;


import com.emrekorkmaz.jpaservice.dto.EmployeeDto;
import com.emrekorkmaz.jpaservice.entity.Employee;
import com.emrekorkmaz.jpaservice.repository.EmployeeRepository;
import com.emrekorkmaz.jpaservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    //localhost:8080/employee

    @GetMapping("/{Id}")
    public ResponseEntity<EmployeeDto> getbyId(@PathVariable("Id") long Id)
    {
        return new ResponseEntity<EmployeeDto>(employeeService.getById(Id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll()
    {
        System.out.println("The count is: " + employeeRepository.count()) ;
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employee)
    {
        return new ResponseEntity<EmployeeDto>(employeeService.save(employee), HttpStatus.OK);

    }

    @PutMapping("/{Id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("Id") long Id, @RequestBody EmployeeDto employeeDto)
    {
        employeeDto.setId(Id);
        return new ResponseEntity<EmployeeDto>(employeeService.update(employeeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<EmployeeDto> deleteById(@PathVariable("Id") long Id)
    {
        return new ResponseEntity<EmployeeDto>(employeeService.deleteById(Id), HttpStatus.OK);
    }
}
