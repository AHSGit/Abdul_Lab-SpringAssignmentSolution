package com.greatlearning.SecureStudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.greatlearning.SecureStudentManagement.entity.Student;
import com.greatlearning.SecureStudentManagement.service.StudentService;

//controller to map the CRUD operations
@Controller

// DELETE and PUT endpoints were returning error 
// "type=Method Not Allowed, status=405. Request method 'GET' not supported"
// hence had to add the below line
@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })

public class StudentController {

	@Autowired
	private StudentService studentservice;

	// visits the add-form
	@GetMapping("/add")
	public String add() {
		return "add-form";
	}

	// saves the data and redirect to students list
	@PostMapping("/save")
	public String addStudent(@ModelAttribute Student student) {
		studentservice.saveStudent(student);

		// redirects to allStudents page
		return "redirect:/allStudents";
	}

	@GetMapping("/allStudents")
	public String findAllStudents(Model theModel) {
		List<Student> students = studentservice.getStudents();
		theModel.addAttribute("Student", students);
		return "students-list";
	}

	// visits the update-form
	@GetMapping("/edit/{studentId}")

	// @PreAuthorize annotation checks the given expression before entering the
	// method
	// and provides access based on defined authorities
	@PreAuthorize("hasAuthority('ADMIN')")
	public String edit(@PathVariable int studentId, Model theModel) {

		// locates the student record to be updated
		Student student = studentservice.getStudentById(studentId);
		theModel.addAttribute("Student", student);

		// sends to update form
		return "update-form";
	}

	// updates the student data and redirects to students list
	@PutMapping("/update/{studentId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String update(@ModelAttribute Student student) {

		// updates the student
		studentservice.updateStudent(student);

		return "redirect:/allStudents";
	}

	// deletes student record after pop-up confirmation
	@DeleteMapping("/delete/{studentId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteStudent(@PathVariable int studentId) {

		studentservice.deleteStudent(studentId);

		return "redirect:/allStudents";
	}

}
