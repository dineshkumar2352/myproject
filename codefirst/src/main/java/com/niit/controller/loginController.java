package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CustomerDao;
import com.niit.dao.ProductDao;
import com.niit.model.Customer;
import com.niit.model.Product;

@Controller
public class loginController {
	@Autowired
	CustomerDao custService;
	@Autowired
	ProductDao productService;
	@RequestMapping("/loginFail")
	public String loginFail() {
		return "loginFail";
	}
	@ModelAttribute("regCommand")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("regCommand") Customer customer, BindingResult Result) {
		try {
			custService.addCustomer(customer);
		} catch (Exception e) {

		}

		if (Result.hasErrors()) {
			return new ModelAndView("/loginFail");
		} else {
			return new ModelAndView("/login");
		}
	}
	
	// Product Controllers

	@RequestMapping("/showProducts")
	public String showProducts(Model model) {
		model.addAttribute("listProduct", this.productService.viewProducts());
		model.addAttribute("listCustomer", this.custService.viewCustomer());
		model.addAttribute("path","resources\\images\\");
		return "showProducts";
	}
	
	// Admin page controls

		@RequestMapping("/admin")
		public String showAdmin(Model model) {
			model.addAttribute("product", new Product());
			model.addAttribute("listProduct", this.productService.viewProducts());
			return "admin";
		}
		
		@ModelAttribute("saveProductCommand")
		public Product getProduct() {
			return new Product();
		}
		@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
		public ModelAndView saveProduct(@ModelAttribute("saveProductCammand") Product product, BindingResult Result) {

			productService.addProduct(product);

			return new ModelAndView("index");
		}
		
		@ModelAttribute("updateProductCommand")
		public Product getUpProduct() {
			return new Product();
		}
		
		@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
		public ModelAndView updateProduct(@ModelAttribute("updateProductCommand") Product product, BindingResult Result) {
			
			productService.editProduct(product);
			return new ModelAndView("admin");
		}
		
		
		
	
	
}
