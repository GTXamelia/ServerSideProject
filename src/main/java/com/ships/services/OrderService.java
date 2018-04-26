package com.ships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.CompanyInterface;
import com.ships.repositories.OrderInterface;
import com.ships.repositories.ShipInterface;

@Service
public class OrderService {

	@Autowired
	private OrderInterface orderInt;
	
	@Autowired
	private ShipInterface shipInt;
	
	@Autowired
	private CompanyInterface companyInt;
	
	@Autowired
	private ShipService shipOb;
	
	private Ship ship;
	private ShippingCompany ShippingCompany;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	// Get all data from the Ship object using the interface
	public ArrayList<OrderInfo> getAll() {
		return (ArrayList<OrderInfo>) orderInt.findAll();
	}

	// Used for adding Ship or updating one
	public OrderInfo save(OrderInfo order) {
		
		
		if (shipInt.findOne(order.getShip().getSid()) != null) {
			ship = shipInt.findOne(order.getShip().getSid());
		}
		
		// Get ShippingCompany that matches orders shipping company
		ShippingCompany = companyInt.findOne(order.getShippingCompany().getScid());
		
		// Set ships shipping company to the orders shipping company
		ship.setShippingCompany(order.getShippingCompany());
		
		// Save ship
		shipOb.save(ship);
		
		// Set order to equal the shipping company details
		order.setShippingCompany(ShippingCompany);
		
		// Set the order date
		order.setDate(dateFormat.format(date));
		
		// Return the saved order
		return orderInt.save(order);
	}
}