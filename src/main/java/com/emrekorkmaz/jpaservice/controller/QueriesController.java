package com.emrekorkmaz.jpaservice.controller;


import com.emrekorkmaz.jpaservice.entities.Employee;
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


    @GetMapping("/findByName")
    public ResponseEntity<List<Employee>> getByFirstName() {

        return ResponseEntity.ok(employeeRepository.findByName("Edin"));
    }

    @GetMapping("/findByFullname")
    public ResponseEntity<List<Employee>> getByNameAndSurname(String name, String surname) {
        return ResponseEntity.ok(employeeRepository.findByNameAndSurname("Edin", "Dzeko"));
    }
}
