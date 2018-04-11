package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
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

	public ArrayList<OrderInfo> getAll() {
		return (ArrayList<OrderInfo>) orderInt.findAll();
	}

	public OrderInfo save(OrderInfo order) {
		
		
		
		
		return orderInt.save(order);
	}

	
}