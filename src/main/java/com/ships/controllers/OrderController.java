package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;
import com.ships.services.OrderService;
import com.ships.services.ShipService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderOb;

	@Autowired
	private ShipService shipOb;

	@Autowired
	private CompanyService companyOb;

	// This handles a HTTP 'GET' request for /showOrders
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) {

		// Get all data from OrderService and add to array list using a new
		// instance of the order object
		ArrayList<OrderInfo> orders = orderOb.getAll();
		
		// Add array list to the 'orders' model
		m.addAttribute("orders", orders);

		// Return 'showOrders' page
		return "showOrders";
	}

	// This handles a HTTP 'GET' request for /addOrder
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("orderAdd") OrderInfo c, HttpServletRequest h, Model m) {

		// Get all data from ShipService and add to array list using a new
		// instance of the ship object
		ArrayList<Ship> ships = shipOb.getAll();

		// Create a map called shipList. Used to show ship details and not just ship ID
		Map<Long, String> shipList = new HashMap<Long, String>();

		// Loop through ships and add the value to 's' 
		for (Ship s : ships) {
			// If shippingCompany is null then the ship has no owner and can be bought
			if (s.getShippingCompany() == null) {
				
				// Add details to shipList map
				shipList.put(s.getSid(), s.getName() + ", Cost = " + s.getCost());
			}
		}

		// Add shipList maop to model
		m.addAttribute("shipList", shipList);

		// Get all data from CompanyService and add to array list using a new
		// instance of the ShippingCompany object
		ArrayList<ShippingCompany> companies = companyOb.getAll();

		// Create a map called companyList. Used to show company details and not just ship ID
		Map<Long, String> companyList = new HashMap<Long, String>();

		// Loop through companies and add the value to 'sc' 
		for (ShippingCompany sc : companies) {
			
			// Add details to map
			companyList.put(sc.getScid(), sc.getName() + ", Balance = " + sc.getBalance());
		}

		// Add companyList maop to model
		m.addAttribute("companyList", companyList);

		// Return 'addOrder' page
		return "addOrder";
	}

	// This handles a HTTP 'POST' request for /addOrder
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo c, BindingResult result, HttpServletRequest h, Model m) {

		// If the page encountered any errors stay on the page
		if (result.hasErrors()) {
			
			// Return 'addOrder' page
			return "addOrder";
			
		// ELse if there is no ship or company selected 
		} else if (c.getShip() == null || c.getShippingCompany() == null) {
			
			// Return 'errorAddOrder' page
			return "errorAddOrder";
			
		// Else if the company cannot afford the ship
		} else if (c.getShip().getCost().compareTo(c.getShippingCompany().getBalance()) == (0 | 1)) {
			
			// Return 'errorAddOrderMoney' page
			return "errorAddOrderMoney";
		} else {

			// Set balance of the order shipping company to the original minus the cost of the ship
			c.getShippingCompany().setBalance(c.getShippingCompany().getBalance().subtract(c.getShip().getCost()));

			// Add order
			orderOb.save(c);
			
			// Add the new ship details
			shipOb.save(c.getShip());
			
			// Add the new shipping company details
			companyOb.save(c.getShippingCompany());

			// Get all data from OrderService and add to array list using a new
			// instance of the Order object
			ArrayList<OrderInfo> orders = orderOb.getAll();
			
			// Add array list to the 'orders' model
			m.addAttribute("orders", orders);

			// Return 'showOrders' page
			return "showOrders";
		}
	}
}