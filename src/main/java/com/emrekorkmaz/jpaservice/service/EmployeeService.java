package com.emrekorkmaz.jpaservice.service;

import com.emrekorkmaz.jpaservice.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {


    public EmployeeDto update(EmployeeDto EmployeeDto);

    public List<EmployeeDto> getAll();

    public EmployeeDto getById(String Id);

    public EmployeeDto save(EmployeeDto EmployeeDto);

    public EmployeeDto delete(String Id);

    public long count();

    public Page<EmployeeDto> findPagination(int pageSize, int pageNo, String sortField, String sortDirection);
}

