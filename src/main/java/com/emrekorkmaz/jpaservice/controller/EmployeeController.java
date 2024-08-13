package com.emrekorkmaz.jpaservice.controller;


import com.emrekorkmaz.jpaservice.dto.EmployeeDto;
import com.emrekorkmaz.jpaservice.entities.Employee;
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

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getbyId(@PathVariable("id") String Id)
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
        return new ResponseEntity<EmployeeDto>(employeeService.save(employee), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") String Id, @RequestBody EmployeeDto employeeDto)
    {
        employeeDto.setId(Id);
        return new ResponseEntity<EmployeeDto>(employeeService.update(employeeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") String Id)
    {
        return new ResponseEntity<EmployeeDto>(employeeService.delete(Id), HttpStatus.OK);
    }
}
