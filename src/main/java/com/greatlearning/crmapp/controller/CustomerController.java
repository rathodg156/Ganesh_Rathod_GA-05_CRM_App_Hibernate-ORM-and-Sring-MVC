package com.greatlearning.crmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crmapp.model.Customer;
import com.greatlearning.crmapp.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list") // /customers/list
	public String listCustomers(Model model) {
		
		System.out.println("Request Received");
		// get Students from db
		List<Customer> customers = customerService.findAll();
		// add to the spring model
		model.addAttribute("customers", customers);
		
		return "customers-list";
	}

	@RequestMapping("/new")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("newCustomer", true);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping("/edit")
	public String showFormForEdit(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.findById(id);

		model.addAttribute("newCustomer", false);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		Customer customer = null;

		if (id == 0) {
			customer = new Customer(firstname, lastname, email);
		} else {
			customer = customerService.findById(id);
			customer.setFirstname(firstname);
			customer.setLastname(lastname);
			customer.setEmail(email);
		}
		customerService.save(customer);

		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String showFormForAdd(@RequestParam("id") int id) {
		customerService.deleteById(id);

		return "redirect:/customers/list";
	}

}