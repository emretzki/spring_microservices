package com.emrekorkmaz.jpaservice.dto;

import lombok.Data;


import java.sql.Timestamp;
import java.util.Date;

@Data
public class EmployeeDto {

    private String id;

    private String name;

    private String surname;

    private String email;

    private String job;

    private int age;

    private String position;

    private Date addedDate;

    private Timestamp createdDate;

    private Timestamp lastUpdateDate;
}
