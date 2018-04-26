package com.ships.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyOb;

	// This handles a HTTP 'GET' request for /showShippingCompanies
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getCompanies(Model m) {

		// Get all data from CompanyService and add to array list using a new
		// instance of the ShippingCompany object
		ArrayList<ShippingCompany> companies = companyOb.getAll();
		
		// Add array list to the 'companies' model
		m.addAttribute("companies", companies);

		// Return 'showShippingCompanies' page
		return "showShippingCompanies";
	}

	// This handles a HTTP 'GET' request for /addShippingCompany
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getCompany(@ModelAttribute("companyAdd") ShippingCompany c, HttpServletRequest h) {
		
		// Return 'showShippingCompanies' page
		return "addShippingCompany";
	}

	// This handles a HTTP 'POST' request for /addShippingCompany
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addCompany(@Valid @ModelAttribute("companyAdd") ShippingCompany c, BindingResult result, HttpServletRequest h, Model m) {
		
		// If the page encountered any errors stay on the page
		if (result.hasErrors()) {
			return "addShippingCompany";
		} else {
			
			// Add the new ship to the object
			companyOb.save(c);

			// Get all data from CompanyService and add to array list using a new
			// instance of the ShippingCompany object
			ArrayList<ShippingCompany> companies = companyOb.getAll();

			// Add array list to the 'companies' model
			m.addAttribute("companies", companies);

			// Return 'showShippingCompanies' page
			return "showShippingCompanies";
		}

	}
}