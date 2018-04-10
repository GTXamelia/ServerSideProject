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

	public ArrayList<ShippingCompany> getAll() {
		return (ArrayList<ShippingCompany>) companyInt.findAll();
	}

	public ShippingCompany save(ShippingCompany company) {
		return companyInt.save(company);
	}

	
}