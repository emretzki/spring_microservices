package com.emrekorkmaz.jpaservice.controller;


import com.emrekorkmaz.jpaservice.entity.Employee;
import com.emrekorkmaz.jpaservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/querymethods")
@RequiredArgsConstructor
public class QueriesController {

    private final EmployeeRepository employeeRepository;


    @GetMapping("/findByFirstName")
    public ResponseEntity<List<Employee>> getByFirstName() {

        return ResponseEntity.ok(employeeRepository.findByFirstName("Edin"));
    }

    @GetMapping("/findByFirstNameAndLastName")
    public ResponseEntity<List<Employee>> getByFirstNameAndLastName(String firstName, String lastName) {
        return ResponseEntity.ok(employeeRepository.findByFirstNameAndLastName("Edin", "Dzeko"));
    }
}
