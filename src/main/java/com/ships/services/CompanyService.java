package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.CompanyInterface;

@Service
public class CompanyService {

	@Autowired
	private CompanyInterface companyInt;

	// Get all data from the ShippingCompany object using the interface
	public ArrayList<ShippingCompany> getAll() {
		return (ArrayList<ShippingCompany>) companyInt.findAll();
	}

	// Used for adding ShippingCompany or updating one
	public ShippingCompany save(ShippingCompany company) {
		return companyInt.save(company);
	}
}