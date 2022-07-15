package com.greatlearning.SecureStudentManagement.service;

import java.util.List;

import com.greatlearning.SecureStudentManagement.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getStudents();

	public Student getStudentById(int studentId);

	public Student updateStudent(Student student);

	public void deleteStudent(int studentId);

}
