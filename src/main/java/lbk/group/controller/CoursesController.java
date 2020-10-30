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
import lbk.group.model.CourseModel;
import lbk.group.service.CourseService;
import lbk.group.service.impl.UserService;

@Controller
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listCourses() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.COURSES);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", userService.getFullName(user.getUsername()));
		modelAndView.addObject("courses",courseService.listCourse());
		return modelAndView;
	}
	
	@GetMapping("/courseform")
	private String redirectCourseForm(@RequestParam(name = "id", required = false) int id, Model model) {
		CourseModel courseModel = new CourseModel();
		if( id!=0) courseModel = courseService.findCourseByIdModel(id);
		model.addAttribute("courseModel", courseModel);
		return ViewConstant.COURSE_FORM;
	}

	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute(name = "courseModel") CourseModel courseModel, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		courseModel.setUsername(user.getUsername());
		courseModel.setLast_update(new Date());
		if(courseService.addCourse(courseModel)!=null) model.addAttribute("result", 1);
		else model.addAttribute("result", 0);
		return "redirect:/courses/listcourses";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/courses/listcourses";
	}
	
	
}
