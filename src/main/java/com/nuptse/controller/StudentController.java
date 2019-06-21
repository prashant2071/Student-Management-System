package com.nuptse.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nuptse.model.Student;
import com.nuptse.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("/student/create");
		return modelAndView;
	}

	@RequestMapping(value = "/student/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@Valid Student student,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		try{
			System.out.println("Student id.......  " + student.getId());	
			Student studentExists = studentService.findStudentById(student.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Student studentExists = studentService.findStudentById(student.getId());
		System.out.println(student);
		if (studentExists != null) {
			bindingResult
					.rejectValue("id", "error.student",
							"There is already a student registered with the id provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/student/create");
		} else {
			System.out.println("New ... ");
			studentService.saveStudent(student);
			modelAndView.addObject("successMessage",
					"Student has been registered successfully");
			modelAndView.addObject("student", new Student());
			modelAndView.setViewName("/student/create");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/student/list", method = RequestMethod.GET)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		List<Student> studentlist = studentService.findAll();
		System.out.println("studentList" + studentlist);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studentlist", studentlist);
		modelAndView.setViewName("/student/list");
		return modelAndView;
	}

	@RequestMapping(value = "/student/show", method = RequestMethod.GET)
	public ModelAndView showCourse(
			@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView modelAndView = new ModelAndView();

		Student student = studentService.findStudentById(id);
		System.out.println("student " + student);
		modelAndView.addObject("student", student);
		modelAndView.setViewName("/student/show");
		return modelAndView;
	}

}
