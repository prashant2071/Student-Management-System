package com.nuptse.controller;

import java.util.List;

import javax.validation.Valid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.nuptse.model.Course;
import com.nuptse.model.User;
import com.nuptse.service.CourseService;
import com.nuptse.service.CourseServiceImpl;

@Controller
public class CourseController {
	
	/*@RequestMapping("/course/create")
    public String hello() {
        return "course/create";
    }*/
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/course/create", method = RequestMethod.GET)
	public ModelAndView  create() {
		
		ModelAndView modelAndView = new ModelAndView();
		Course course = new Course();
		modelAndView.addObject("course", course);
		modelAndView.setViewName("course/create");
		return modelAndView;
	}
	
	@RequestMapping(value = "/course/edit", method = RequestMethod.GET)
	public ModelAndView edit( @RequestParam(value="id",required=false ) Integer id){
		
		ModelAndView modelAndView = new ModelAndView();
		  Course course= courseService.findByCourseId(id);
		    //System.out.println("course " + course);
		            modelAndView.addObject("course",course);
		            modelAndView.setViewName("course/create");
		        
		        return modelAndView;
				}
	 @RequestMapping(value = "/course/create", method = RequestMethod.POST)
	    public ModelAndView createNewCourse(@Valid Course course, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println("Course .......  " + course);
	        Course courseExists = courseService.findCourseByCourseName(course.getCourseName());
	        System.out.println(course);
	        if (courseExists != null) {
	            bindingResult
	                    .rejectValue("coursename", "error.user",
	                            "There is already a course registered with the same name");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("course/create");
	        } else {
	        	System.out.println("Here ... ");
	            courseService.saveCourse(course);
	            modelAndView.addObject("successMessage", "course has been registered successfully");
	            modelAndView.addObject("course", new Course());
	            modelAndView.setViewName("course/create");
	        }
	        return modelAndView;
	    }
	/*	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView modelAndView = new ModelAndView();
			//Course course = new Course();
			//modelAndView.addObject("course", course);
			modelAndView.setViewName("course/list");
			return modelAndView;
		}*/
		/* @RequestMapping(value = "/course/list", method = RequestMethod.GET)
		    public String index(Model md){
		        md.addAttribute("course",service.findAll());
		        return "course";
		    }*/
		@RequestMapping(value = "/course/list", method = RequestMethod.GET)
		public ModelAndView saveStudent(@ModelAttribute Course course) {
			List<Course> courselist= courseService.findAll();
			System.out.println("courseList" + courselist);
			//courseList.forEach(course -> System.out.println("user"))
			ModelAndView modelAndView = new ModelAndView();
			 modelAndView.addObject("courselist", courselist);
			 modelAndView.setViewName("/course/list");
			return modelAndView;
		}
		 @RequestMapping(value = "/course/show", method = RequestMethod.GET)
		    public ModelAndView showCourse(
			 @RequestParam(value="id",required=false )
					 Integer id){
		        ModelAndView modelAndView = new ModelAndView();
		      
		        Course course= courseService.findByCourseId(id);
		    System.out.println("course " + course);
		            modelAndView.addObject("course",course);
		            modelAndView.setViewName("course/show");
		        
		        return modelAndView;
		    }	 
		

}
