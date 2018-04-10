package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.CompanyInterface;

@Service
public class CompanyService {

	@Autowired
	private CompanyInterface shipInt;

	public ArrayList<ShippingCompany> getAll() {
		return (ArrayList<ShippingCompany>) shipInt.findAll();
	}

	public ShippingCompany save(ShippingCompany comp) {
		return shipInt.save(comp);
	}

	
}