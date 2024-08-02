package com.emrekorkmaz.jpaservice.service;

import com.emrekorkmaz.jpaservice.dto.EmployeeDto;
import com.emrekorkmaz.jpaservice.entity.Employee;

import java.util.List;


public interface EmployeeService {

    public EmployeeDto save(EmployeeDto EmployeeDto);

    public EmployeeDto update(EmployeeDto EmployeeDto);

    public List<EmployeeDto> getAll();

    public EmployeeDto getById(long Id);

    public EmployeeDto deleteById(long Id);

    public long count();
}

