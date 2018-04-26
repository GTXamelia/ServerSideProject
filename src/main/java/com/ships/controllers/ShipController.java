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

	// This handles a HTTP 'GET' request for /showships
	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String getShips(Model m) {

		// Get all data from ShipService and add to array list using a new
		// instance of the ship object
		ArrayList<Ship> ships = shipOb.getAll();
		
		// Add array list to the 'ships' model
		m.addAttribute("ships", ships);

		// Return 'showShips' page
		return "showShips";
	}

	// This handles a HTTP 'GET' request for /addShip
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("shipAdd") Ship c, HttpServletRequest h) {
		
		// Return 'addShip' page
		return "addShip";
	}

	// This handles a HTTP 'POST' request for /addShip
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipAdd") Ship c, BindingResult result, HttpServletRequest h, Model m) {

		// If the page encountered any errors stay on the page
		if (result.hasErrors()) {
			
			// Return 'addShip' page
			return "addShip";
		} else {
			
			// Add the new ship to the object
			shipOb.save(c);

			// Get all data from the ship object and add to array list using a new
			// instance of the ship object 
			ArrayList<Ship> ships = shipOb.getAll();

			// Add ship to the model
			m.addAttribute("ships", ships);

			// Return 'showShips' page
			return "showShips";
		}
	}
}