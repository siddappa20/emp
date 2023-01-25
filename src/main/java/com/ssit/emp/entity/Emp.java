package com.ssit.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "emp")
@Data
public class Emp {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Please enter proper employee name")
    @Size(min=3, message = "Name should be minimum 3 characters")
    @Size(max=16, message = "Name should not be greater than 16 characters")
    private String name;

    @NotNull(message = "Please enter a valid salary")
    @Min(value=18, message = "Age must be at least 18")
    @Max(value=60, message = "Age should not be less than 60")
    @Column(name = "age")
    private Integer age;

    @Column(name = "dep_id")
    private Long depId;

}