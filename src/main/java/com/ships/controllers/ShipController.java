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

import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {
	
	@Autowired
	private ShipService shipOb;
	
	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String getShips(Model m) {

		ArrayList<Ship> ships = shipOb.getAll();
		m.addAttribute("ships", ships);

		return "showShips";
	}
	
}
