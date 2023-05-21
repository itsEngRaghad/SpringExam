package com.example.thespringexam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "id shouldn't be empty")
    private int id;

    @NotEmpty(message = "name shouldn't be empty")
    private String name;

    @NotNull(message = "salary shouldn't be null")
    private double salary;
}
