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

import com.ships.model.OrderInfo;
import com.ships.services.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderOb;
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) {

		ArrayList<OrderInfo> orders = orderOb.getAll();
		m.addAttribute("orders", orders);

		return "showOrders";
	}
		
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("orderAdd") OrderInfo c, HttpServletRequest h, Model m) {
		
		ArrayList<OrderInfo> orders = orderOb.getAll();
		m.addAttribute("orders", orders);
		
		return "createOrder";
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo c, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			orderOb.save(c);
			
			ArrayList<OrderInfo> orders = orderOb.getAll();
	
			m.addAttribute("orders", orders);
	
			return "createOrder";
		}
	}
}