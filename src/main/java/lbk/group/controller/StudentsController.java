package lbk.group.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lbk.group.constant.ViewConstant;
import lbk.group.model.StudentModel;
import lbk.group.service.StudentService;
import lbk.group.service.impl.UserService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@GetMapping("/liststudents")
	public ModelAndView listStudents() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.STUDENTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", userService.getFullName(user.getUsername()));
		modelAndView.addObject("students",studentService.listStudent());
		return modelAndView;
	}
	
	@GetMapping("/studentform")
	private String redirectStudentForm(@RequestParam(name = "id", required = false) int id, Model model) {
		StudentModel studentModel = new StudentModel();
		if( id!=0) studentModel = studentService.findStudentByIdModel(id);
		model.addAttribute("studentModel", studentModel);
		return ViewConstant.STUDENT_FORM;
	}

	
	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute(name = "studentModel") StudentModel studentModel, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		studentModel.setUsername(user.getUsername());
		studentModel.setLast_update(new Date());
		if(studentService.addStudent(studentModel)!=null) model.addAttribute("result", 1);
		else model.addAttribute("result", 0);
		return "redirect:/students/liststudents";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/students/liststudents";
	}
}
