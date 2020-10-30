package lbk.group.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;

import lbk.group.constant.ViewConstant;
import lbk.group.model.ContactModel;
import lbk.group.service.ContactService;
import lbk.group.service.impl.UserService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	private static final Log LOG = LogFactory.getLog(ContactController.class);

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/listcontacts";
	}

	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	private String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {
		ContactModel contactModel = new ContactModel();
		if (id != 0) {
			contactModel = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
		if (null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/contacts/listcontacts";
	}

	@GetMapping("/listcontacts")
	public ModelAndView listContacts() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		modelAndView.addObject("username", userService.getFullName(user.getUsername()));
		modelAndView.addObject("contacts", contactService.listContacts());
		return modelAndView;
	}

	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return listContacts();
	}
}
