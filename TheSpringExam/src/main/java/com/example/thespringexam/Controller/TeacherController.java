package com.example.thespringexam.Controller;

import com.example.thespringexam.APIResponse.APIResponse;
import com.example.thespringexam.Model.Teacher;
import com.example.thespringexam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;




    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new APIResponse(message));
       }
       teacherService.addTeacher(teacher);
       return ResponseEntity.status(200).body("teacher has been added");
    }

    //update
    @PutMapping("/update/{teacherID}")

    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, Errors errors, @PathVariable int teacherID){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new APIResponse(message));
       }
       boolean isUpdate= teacherService.updateTeacher(teacherID,teacher);
       if (isUpdate){
           return ResponseEntity.status(200).body("teacher has been updated");
       }
       return ResponseEntity.status(400).body("wrong id");
    }


    //delete teacher
    @DeleteMapping("/delete/{teacherID}")
    public ResponseEntity deleteTeacher(@PathVariable int teacherID ){
       boolean isDeleted= teacherService.deleteTeacher(teacherID);
       if(isDeleted){
           return ResponseEntity.status(200).body("teacher has been deleted");
       }
       return ResponseEntity.status(400).body("wrong id");
    }


    //Create an endpoint that takes a teacher id and returns one teacher .

    //get teacher by id
    @GetMapping("/getbyid/{TeacherID}")
    public ResponseEntity getTeacherByID(@PathVariable int TeacherID){
        ArrayList<Teacher> teachers=teacherService.getTeachers();
        for (int i = 0; i < teachers.size(); i++)
        {
            if (teachers.get(i).getId()==TeacherID)
            {
                teachers.get(i);
            }

        }
        return ResponseEntity.status(200).body(teachers);
    }
}
