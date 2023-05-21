package com.example.thespringexam.Service;

import com.example.thespringexam.Model.Teacher;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers=new ArrayList<>();

    //get array

    public ArrayList<Teacher> getTeachers(){

        return teachers;
    }


//add teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }


    //updating Teacher if it's exist
    public boolean updateTeacher(int TeacherID, Teacher teacher)
    {
        for (int i = 0; i < teachers.size(); i++)
        {
            if (teachers.get(i).getId()==TeacherID)
            {
                teachers.set(i, teacher);
                return true;
            }

        }
        return false;
}


    //Delete teacher if it's exist

    public boolean deleteTeacher(int TeacherID){
        for (int i=0; i<teachers.size();i++){
            if(teachers.get(i).getId()==TeacherID){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

}