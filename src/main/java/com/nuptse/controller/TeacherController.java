package com.nuptse.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nuptse.model.Teacher;
import com.nuptse.service.TeacherService;

import java.util.List;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = { "/teacher/create" }, method = RequestMethod.GET)
	public ModelAndView createTeacher() {
		System.out.println("First create ... ");
		ModelAndView modelAndView = new ModelAndView();
		Teacher teacer = new Teacher();
		modelAndView.addObject(teacer);
		modelAndView.setViewName("teacher/create");
		return modelAndView;
	}
	
	

	@RequestMapping(value = { "/teacher/list" }, method = RequestMethod.GET)
	public ModelAndView listTeacher() {
		List<Teacher> teacherList = teacherService.findAll();
		teacherList.forEach(teacher -> System.out.println("teacher name:" + teacher.getName()));
		ModelAndView modelAndView = new ModelAndView();
		// Teacher teacer = new Teacher();
		modelAndView.addObject("teacherlist", teacherList);
		modelAndView.setViewName("teacher/list");
		return modelAndView;
	}

	@RequestMapping(value = { "/teacher/show" }, method = RequestMethod.GET)
	public ModelAndView showTeacher(@RequestParam(value="id",required=false) Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Teacher teacher=teacherService.findTeacherById(id);
		modelAndView.addObject(teacher);
		//Teacher teacherExists = teacherService.findTeacherById(teacher.getId());

		modelAndView.setViewName("teacher/show");
		return modelAndView;
	}
	
	@RequestMapping(value = "/teacher/create", method = RequestMethod.POST)
	public ModelAndView createNewTeacher(@Valid Teacher teacher, BindingResult bindingResult) {
		System.out.println("Second create ... ");
		ModelAndView modelAndView = new ModelAndView();
		Teacher teacherExists = teacherService.findTeacherByName(teacher.getName());

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("teacher/create");
		} else {
			teacherService.saveTeacher(teacher);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("Teacher", new Teacher());
			modelAndView.setViewName("teacher/create");

		}
		return modelAndView;
	}
	@RequestMapping(value="/teacher/edit", method=RequestMethod.GET)
	public ModelAndView editTeacher(@RequestParam(value="id",required=false) Integer id){
		//System.out.println("editeacher....");

		ModelAndView modelAndView=new ModelAndView();
		Teacher teacher=teacherService.findTeacherById(id);
		modelAndView.addObject(teacher);
		modelAndView.setViewName("teacher/create");

		return modelAndView;
	}
/*	@RequestMapping(value = "/teacher/edit", method = RequestMethod.POST)
	public ModelAndView editNewTeacher(@Valid Teacher teacher, BindingResult bindingResult) {
		System.out.println("Second create ... ");
		ModelAndView modelAndView = new ModelAndView();
		Teacher teacherExists = teacherService.findTeacherById(teacher.getId());

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("teacher/create");
		} else {
			teacherService.saveTeacher(teacher);
			//-modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("Teacher", new Teacher());
			modelAndView.setViewName("teacher/create");

		}
		return modelAndView;
	}
*/
}
