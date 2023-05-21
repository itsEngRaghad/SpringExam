package com.example.thespringexam.Service;

import com.example.thespringexam.Model.Student;
import com.example.thespringexam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student>students=new ArrayList<>();

    //get array

    public ArrayList<Student> getStudents(){

        return students;
    }


    //add student
    public void addStudent(Student student) {
        students.add(student);
    }


    //updating student if it's exist
    public boolean updateStudent(int StudentID, Student student)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getId()==StudentID)
            {
                students.set(i, student);
                return true;
            }

        }
        return false;
    }


    //Delete student if it's exist

    public boolean deleteStudent(int StudentID){
        for (int i=0; i<students.size();i++){
            if(students.get(i).getId()==StudentID){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
