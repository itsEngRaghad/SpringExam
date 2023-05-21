package com.example.thespringexam.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "id should not be empty")
    private int id;

    @NotEmpty(message = "name shouldn't be empty")
    private String name;

    @NotEmpty(message = "age shouldn't be empty")
    private String age;

    @NotEmpty(message = "major shouldn't be empty")

    private String major;


}
