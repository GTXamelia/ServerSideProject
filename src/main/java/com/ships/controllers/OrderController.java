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
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) {

		ArrayList<OrderInfo> orders = orderOb.getAll();
		m.addAttribute("orders", orders);

		return "showOrders";
	}
		
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("orderAdd") OrderInfo c, HttpServletRequest h, Model m) {
		
		ArrayList<Ship> ships = shipOb.getAll();
		
		Map<Long,String> shipList = new HashMap<Long,String>();
		
		for (Ship s : ships) {	
			if (s.getShippingCompany() == null){
				shipList.put(s.getSid(), s.getName() + ", Cost = " + s.getCost());
			}
		}
		
		m.addAttribute("shipList", shipList);
		
		
		ArrayList<ShippingCompany> companies = companyOb.getAll();
		
		Map<Long,String> companyList = new HashMap<Long,String>();
		
		for (ShippingCompany sc : companies) {	
			companyList.put(sc.getScid(), sc.getName() + ", Balance = " + sc.getBalance());
		}
		
		m.addAttribute("companyList", companyList);
		
		return "createOrder";
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo c, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			
			orderOb.save(c);
			shipOb.save(c.getShip());
			
			
			ArrayList<OrderInfo> orders = orderOb.getAll();
			m.addAttribute("orders", orders);
			
	
			return "showOrders";
		}
	}
}