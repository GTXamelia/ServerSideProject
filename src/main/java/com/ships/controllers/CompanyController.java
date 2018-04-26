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
	
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getCompanies(Model m) {

		ArrayList<ShippingCompany> companies = companyOb.getAll();
		m.addAttribute("companies", companies);

		return "showShippingCompanies";
	}
		
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getCompany(@ModelAttribute("companyAdd") ShippingCompany c, HttpServletRequest h) {
		return "addShippingCompany";
	}
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addCompany(@Valid @ModelAttribute("companyAdd") ShippingCompany c, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addShippingCompany";
		} else {
			companyOb.save(c);
			
			ArrayList<ShippingCompany> companies = companyOb.getAll();
	
			m.addAttribute("companies", companies);
	
			return "showShippingCompanies";
		}
		
	}
}