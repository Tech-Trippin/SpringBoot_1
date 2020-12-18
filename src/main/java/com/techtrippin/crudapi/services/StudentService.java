package com.techtrippin.crudapi.services;

import com.techtrippin.crudapi.entity.Student;
import com.techtrippin.crudapi.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> retrieveAllStudents() {

        return studentRepo.findAll();

    }

    public Student newStudent(Student student) {
         return studentRepo.save(student);
    }

    public Student getStudentById(Integer id) {
       return studentRepo.getOne(id);
    }

    public void deleteStudentById(Integer id) {
        studentRepo.deleteById(id);
    }
}
