package com.contactapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactapp.DTO.Contact;
import com.contactapp.service.ContactService;

@Controller
public class ViewContactController {

	private static final Logger logger=LoggerFactory.getLogger(ViewContactController.class);
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/updateContact")
	public String updateContact(@RequestParam("cid")  Integer id, Model model) { // capture request parameter value whose key is cid and store in id variable
		 logger.info("updateContact Method started");
		Contact contactById = contactService.getContactById(id);
		model.addAttribute("contactObj", contactById); // In savecontactcontroller we are using contactObj as a key to send empty object to get data from UI and here we are sending table data to UI
		                                               // It is called two way data binding  public String viewPage(Model model) and public String updateContact(@RequestParam("cid")  Integer id, Model model)
		logger.info("updateContact Method ended");                                              // are the same methods 
		return "index1";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer id) {
		logger.info("deleteContact Method started");
		contactService.deleteContactById(id);
		logger.info("deleteContact Method ended");
		return "redirect:viewContacts"; // To other method 
	}

}
