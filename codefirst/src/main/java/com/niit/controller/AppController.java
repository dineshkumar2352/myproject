package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Controller
public class AppController {
	
	@Autowired
	CustomerDao custDao;

	@RequestMapping("/")
	public String customerPage(Model model){
		model.addAttribute("loginCheck","logout");
		return "index";
	}
	
	@ModelAttribute("regcmd")
	public Customer getCustomerCmd(){
		return new Customer();
	}
	
	@RequestMapping(value = "/customer.do" , method = RequestMethod.POST)
	public String custOperations(@ModelAttribute("regcmd") Customer cust, Model model ){
		custDao.addCustomer(cust);
		model.addAttribute("cust", cust);
		return "welcome";
	}
	
	@RequestMapping("/index")
	public String showHome_(@RequestParam("login") String login, Model model){
		System.out.println(login);
		if(login.equals("true")){
			System.out.println(login);
			model.addAttribute("loginCheck","login");
			return "index";
		}
		else{
			System.out.println("Login Else");
			model.addAttribute("loginCheck","logout");
			return "index";
		}
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return "logout";
	}	
	
	@RequestMapping("/Aboutus")
	public String showAboutUs(){
		return "Aboutus";
	}

	@RequestMapping("/customer")
	public String custRegister()
	{
		return "customer";
	}
	@RequestMapping("/customerlist")
	public String viewCustomer(Model model)
	{
		model.addAttribute("custList", this.custDao.viewCustomer());
		return "customerlist";
	}
	
	
	
}
