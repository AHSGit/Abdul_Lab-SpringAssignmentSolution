package com.greatlearning.SecureStudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.SecureStudentManagement.entity.Student;

// extending JpaRepository to get generic CRUD methods
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
