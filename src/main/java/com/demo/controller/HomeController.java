package com.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entity.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private String name="qwertyu";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/addPerson",method=RequestMethod.GET)
	public String loadPage(Model model)
	{
		model.addAttribute("personInfo", new Person());
		return "Registration";
	}
	
	@RequestMapping(value="/addPerson",method=RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("personInfo")Person person,BindingResult bindingResult )
	{
		logger.info(""+person);
		if(bindingResult.hasErrors())
		{
			
			logger.info("fname:"+bindingResult.getFieldValue("fname"));
	       return "Registration";		
		}
		else 
		{
			return "home";
		}
		
	}
}
