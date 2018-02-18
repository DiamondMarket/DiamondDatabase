package com.diamondmarket.diamonds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diamondmarket.diamonds.model.Diamond;
import com.diamondmarket.diamonds.model.Supplier;
import com.diamondmarket.diamonds.repository.DiamondRepository;

@Service
public class DiamondService {

	@Autowired
	private DiamondRepository diamondRepository;
	
	public List<Diamond> getAllDiamonds() {
		List<Supplier> list = diamondRepository.findAll();
		List<Diamond> diamondlist =  new ArrayList<>();
		
		for(Supplier s: list)
			diamondlist.addAll(s.getDiamonds());
		
		return diamondlist;
	}

	public Supplier addDiamonds(ArrayList<Diamond> list, String id) {
		Supplier supplier = new Supplier();
		supplier.set_id(id);
		supplier.setDiamonds(list);
		Supplier supplier1 = diamondRepository.save(supplier);
		return supplier1;
	}

	public void deleteSupplier(String supplierId) {
		diamondRepository.delete(supplierId);
	}

	
}
