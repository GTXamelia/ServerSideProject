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
	private CompanyService compOb;
	
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getCompanies(Model m) {

		ArrayList<ShippingCompany> comp = compOb.getAll();
		m.addAttribute("comp", comp);

		return "showShippingCompanies";
	}
		
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getCompany(@ModelAttribute("compAdd") ShippingCompany c, HttpServletRequest h) {
		return "addShippingCompany";
	}
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addCompany(@Valid @ModelAttribute("compAdd") ShippingCompany c, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addShippingCompany";
		} else {
			compOb.save(c);
			
			ArrayList<ShippingCompany> comp = compOb.getAll();
	
			m.addAttribute("comp", comp);
	
			return "addShippingCompany";
		}
	}
}