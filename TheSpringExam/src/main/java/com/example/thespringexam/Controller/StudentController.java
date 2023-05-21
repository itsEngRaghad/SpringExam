package com.example.thespringexam.Controller;

import com.example.thespringexam.APIResponse.APIResponse;
import com.example.thespringexam.Model.Student;
import com.example.thespringexam.Model.Teacher;
import com.example.thespringexam.Service.StudentService;
import com.example.thespringexam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;




    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students=studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student has been added");
    }

    //update
    @PutMapping("/update/{studentID}")

    public ResponseEntity updateStudent(@Valid @RequestBody Student student, Errors errors, @PathVariable int studentID){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        boolean isUpdate= studentService.updateStudent(studentID,student);
        if (isUpdate){
            return ResponseEntity.status(200).body("student has been updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //delete student
    @DeleteMapping("/delete/{studentID}")
    public ResponseEntity deleteStudent(@PathVariable int studentID ){
        boolean isDeleted= studentService.deleteStudent(studentID);
        if(isDeleted){
            return ResponseEntity.status(200).body("student has been deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //Create an endpoint that takes a student name and returns one student .

    @GetMapping("/getbyid/{StudentName}")
    public ResponseEntity getTeacherByID(@PathVariable int StudentName){
        ArrayList<Student> students=studentService.getStudents();
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getName().equals(StudentName))
            {
                students.get(i);
            }

        }
        return ResponseEntity.status(200).body(students);
    }

}