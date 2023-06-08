package com.contactapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contactapp.DTO.Contact;
import com.contactapp.service.ContactService;



@Controller
public class SaveContactController {
	
	private static final Logger logger=LoggerFactory.getLogger(SaveContactController.class);

	@Autowired
	ContactService contactService;

	@GetMapping("/")
	public String viewPage(Model model) {
       logger.info("Method started");
		Contact contactObj = new Contact();
		model.addAttribute("contactObj", contactObj);
		logger.info("Method ended");
		return "index1";
	}

	@PostMapping("/saveContact")
	public String saveContactButton(@ModelAttribute("contactObj") Contact c, RedirectAttributes redirect) {  // Here we are using redirect attribute to resolve double posting problem
		                                                                                                     // Double posting means Once data entered and clicked on submit it should be saved only once 
		logger.info("saveContactButton Method started");                                                                             //If we use model attribute this problem cannot be solve
		boolean isSaved = contactService.saveContact(c);   
		if (isSaved) {
			logger.info("Contact saved");
			if (c.getContactId() != null) {
				redirect.addFlashAttribute("succMsg", "Contact Updated Successfully..."); //       addAttribute("succMsg", "Contact Updated Successfully...");
			}
			else {
				redirect.addFlashAttribute("succMsg", "Contact saved Successfully...");
			}
		} 
		else {
			redirect.addFlashAttribute("errMsg", "Failed to save contact...");
		}
		logger.info("saveContactButton method ended");
		return "redirect:/";   // From here we are redirecting to existing method "/" , we can also redirect to any method 
	}

	@GetMapping("/viewContacts")
	public String displayAllContacts(Model model) {
		 logger.info("displayAllContacts Method started");
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("allcontacts", allContacts);
		 logger.info("displayAllContacts Method ended");
		return "viewContact";
	}
}
