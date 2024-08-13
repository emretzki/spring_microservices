package com.emrekorkmaz.jpaservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection= "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*
@Table(name = "employee")
*/
public class Employee {

    @Id
    @Column(name = "_id")
    private String id;

    @NotEmpty
    @NotBlank
    private String name;

    private String surname;

    @Column(unique = true)
    @Size(min=10, max=50)
    @Email
    @Pattern(regexp = "[a-zA-z0-9]")
    private String email;

    private String job;

    @Min(18)
    @Max(100)
    //DecimalMin
    private int age;

    private String position;

    @CreationTimestamp
    private Date addedDate;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastUpdateDate;
}
