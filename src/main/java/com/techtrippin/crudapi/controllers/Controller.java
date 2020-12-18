package com.techtrippin.crudapi.controllers;

import com.techtrippin.crudapi.entity.Student;
import com.techtrippin.crudapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return studentService.retrieveAllStudents();
    }

    @PostMapping("/student/new")
    public Student createStudent(@RequestBody Student student ){
        return studentService.newStudent(student);
    }

    @PutMapping("/student/update")
    public ResponseEntity<Object> updateStudent(@RequestBody Student updateStudent){
        Student oldStudent = studentService.getStudentById(updateStudent.getId());
        if(oldStudent !=null){
            oldStudent.setId(updateStudent.getId());
            oldStudent.setFirstName(updateStudent.getFirstName());
            oldStudent.setLastName(updateStudent.getLastName());
            oldStudent.setSchool_code(updateStudent.getSchool_code());
            studentService.newStudent(oldStudent);
            return ResponseEntity.ok().body(new String("Student was updated successfully"));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Object>deleteStudent(@PathVariable(value="id") Integer id){
        Student deleteStudent = studentService.getStudentById(id);
        if(deleteStudent !=null){
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().body(new String("Student was delete successfully"));
        }
        return ResponseEntity.notFound().build();
    }
}
