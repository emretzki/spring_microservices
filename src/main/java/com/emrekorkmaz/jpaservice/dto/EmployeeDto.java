package com.emrekorkmaz.jpaservice.dto;

import lombok.Data;


import java.sql.Timestamp;

@Data
public class EmployeeDto {

    private long Id;

    private String FirstName;

    private String LastName;

    private String Email;

    private int Age;

    private Timestamp CreatedDate;

    private Timestamp LastUpdateDate;
}
