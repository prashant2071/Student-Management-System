package com.nuptse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nuptse.model.Exam;
import com.nuptse.model.User;
import com.nuptse.service.ExamService;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;


    @RequestMapping(value="/exam/create", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Exam exam = new Exam();
        modelAndView.addObject("exam", exam);    //("String",object)
        modelAndView.setViewName("/exam/create");
        return modelAndView;
    }

    @RequestMapping(value = "/exam/create", method = RequestMethod.POST)
    public ModelAndView createNewExam(@Valid Exam exam, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Exam examExists = examService.findExamByFirstname(exam.getFirstname());
        if (examExists != null) {
            bindingResult
                    .rejectValue("Firstname", "error.exam",
                            "There is already a user registered with the subject provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/exam/create");
        } else {
            examService.saveExam(exam);
            modelAndView.addObject("successMessage", "Exam has been registered successfully");
            modelAndView.addObject("exam", new Exam());
            modelAndView.setViewName("/exam/create");

        }
        return modelAndView;
    }
  
	@RequestMapping(value = "/exam/list", method = RequestMethod.GET)
	public ModelAndView saveStudent(@ModelAttribute Exam exam) {
		List<Exam> examlist= examService.findAll();
	//	System.out.println("examList" + examlist);
		//examList.forEach(exam -> System.out.println("user"))
		ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("examlist", examlist);
		 modelAndView.setViewName("/exam/list");
		return modelAndView;
	}
	    @RequestMapping(value = "/exam/show", method = RequestMethod.GET)
	    public ModelAndView showExam(
		 @RequestParam(value="id",required=false )
				 Integer id){
	        ModelAndView modelAndView = new ModelAndView();
	      
	     Exam exam  = examService.findExamById(id);
	    System.out.println("exam " + exam);
	            modelAndView.addObject( "exam", exam);// html content ko data poila yo object ma aauxa
	            
	            
	            modelAndView.setViewName("exam/show");
	        
	        return modelAndView;
	    }
	    @RequestMapping(value = "/exam/edit", method = RequestMethod.POST)
	    public ModelAndView createNewExam1(@Valid Exam exam, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();
	        Exam examExists = examService.findExamById(exam.getId());
	        if (examExists != null) {
	            bindingResult
	                    .rejectValue("Firstname", "error.exam",
	                            "There is already a user registered with the subject provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("/exam/edit");
	        } else {
	            examService.saveExam(exam);
	            modelAndView.addObject("successMessage", "Exam has been registered successfully");
	            modelAndView.addObject("exam", new Exam());
	            modelAndView.setViewName("/exam/edit");

	        }
	        return modelAndView;
	    }
}
