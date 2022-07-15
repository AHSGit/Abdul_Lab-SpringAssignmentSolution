package com.greatlearning.SecureStudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.SecureStudentManagement.entity.Student;
import com.greatlearning.SecureStudentManagement.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentrepository;
	
	public Student saveStudent(Student student) {
        return studentrepository.save(student);
    }

    public List<Student> getStudents() {
        return studentrepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentrepository.findById(studentId).orElse(null);
    }

    public void deleteStudent(int studentId) {
        studentrepository.deleteById(studentId);
    }

    public Student updateStudent(Student student) {
        Student tempStudent = studentrepository.findById(student.getStudentId()).orElse(null);
        tempStudent.setFirstName(student.getFirstName());
        tempStudent.setLastName(student.getLastName());
        tempStudent.setCourse(student.getCourse());
        tempStudent.setCountry(student.getCountry());
        return studentrepository.save(tempStudent);
    }

}
