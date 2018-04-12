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

	public ArrayList<OrderInfo> getAll() {
		return (ArrayList<OrderInfo>) orderInt.findAll();
	}

	public OrderInfo save(OrderInfo order) {
		
		ship = shipInt.findOne(order.getShip().getSid());
		ShippingCompany = companyInt.findOne(order.getShippingCompany().getScid());
		
		ship.setShippingCompany(order.getShippingCompany());
		
		shipOb.save(ship);
		
		order.setShippingCompany(ShippingCompany);
		order.setDate(dateFormat.format(date));
		
		return orderInt.save(order);
	}
}