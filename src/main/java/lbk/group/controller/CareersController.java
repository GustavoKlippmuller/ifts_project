package lbk.group.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lbk.group.constant.ViewConstant;
import lbk.group.model.CareerModel;
import lbk.group.service.CareerService;
import lbk.group.service.impl.UserService;

@Controller
@RequestMapping("/careers")
public class CareersController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("careerServiceImpl")
	private CareerService careerService;

	@GetMapping("/listcareers")
	public ModelAndView listCareers() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CAREERS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", userService.getFullName(user.getUsername()));
		modelAndView.addObject("careers",careerService.listCareers());
		return modelAndView;
	}
	
	@GetMapping("/careerform")
	private String redirectCareerForm(@RequestParam(name = "id", required = false) int id, Model model) {
		CareerModel careerModel = new CareerModel();
		if( id!=0) careerModel = careerService.findCareerByIdModel(id);
		System.out.println(careerModel.getStudyPlanModels().toString());
		model.addAttribute("careerModel", careerModel);
		model.addAttribute("studyPlans", careerModel.getStudyPlanModels());
		return ViewConstant.CAREER_FORM;
	}

	
	@PostMapping("/addcareer")
	public String addCareer(@ModelAttribute(name = "careerModel") CareerModel careerModel, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		careerModel.setUsername(user.getUsername());
		careerModel.setLast_upDate(new Date());
		if(careerService.addCareer(careerModel)!=null) model.addAttribute("result", 1);
		else model.addAttribute("result", 0);
		return "redirect:/careers/listcareers";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/careers/listcareers";
	}

}
