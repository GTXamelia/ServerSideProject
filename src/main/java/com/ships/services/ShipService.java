package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipInterface;

@Service
public class ShipService {

	@Autowired
	private ShipInterface shipInt;

	// Get all data from the Ship object using the interface
	public ArrayList<Ship> getAll() {
		return (ArrayList<Ship>) shipInt.findAll();
	}

	// Used for adding Ship or updating one
	public Ship save(Ship ship) {
		return shipInt.save(ship);
	}
}