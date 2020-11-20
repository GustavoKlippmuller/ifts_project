package lbk.group.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import lbk.group.constant.ViewConstant;
import lbk.group.model.StudyPlanModel;
import lbk.group.service.StudyPlanService;
import lbk.group.service.impl.UserService;

@Controller
@RequestMapping("/studyplans")
public class StudyPlanController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("studyPlanServiceImpl")
	private StudyPlanService studyPlanService;
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);


	@GetMapping("/studyplanform")
	private String redirectStudyPlanForm(@RequestParam(name = "id", required = false) int id,
			@RequestParam(name = "idCareer", required = true) int idCareer, Model model) {
		StudyPlanModel studyPlanModel = new StudyPlanModel();
		studyPlanModel.setIdCareer(idCareer);
		if (id != 0)
			studyPlanModel = studyPlanService.findStudyPlanByIdModel(id);
		LOG.info("Datos obtenidos: " + studyPlanModel.toString());
		model.addAttribute("planModel", studyPlanModel);
		return ViewConstant.STUDYPLAN_FORM;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/careers/careerform";
	}

	@PostMapping("/addstudyplan")
	public String addStudyPlan(@ModelAttribute(name = "planModel") StudyPlanModel planModel, Model model) {
		LOG.info("Datos del Plan: " + planModel.toString());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		planModel.setUsername(user.getUsername());
		planModel.setLastUpdate(new Date());
		if (studyPlanService.addStudyPlan(planModel) != null)
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		return "redirect:/careers/careerform?id="+planModel.getIdCareer();
	}
}