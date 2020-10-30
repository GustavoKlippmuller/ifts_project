package lbk.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lbk.group.constant.ViewConstant;
import lbk.group.service.impl.UserService;

@Controller
public class MainController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	// private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping({ "/main" })
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.MAIN);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username",userService.getFullName(user.getUsername()));
		return modelAndView;
	}

}
