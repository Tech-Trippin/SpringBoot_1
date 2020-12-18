package com.techtrippin.crudapi.repositories;

import com.techtrippin.crudapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
