package com.emrekorkmaz.jpaservice.repository;

import com.emrekorkmaz.jpaservice.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByName(String name);

    List<Employee> findByNameAndSurname(String name, String surname);
}
