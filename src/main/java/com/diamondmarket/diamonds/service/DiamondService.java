package com.diamondmarket.diamonds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diamondmarket.diamonds.model.Diamond;
import com.diamondmarket.diamonds.model.Supplier;
import com.diamondmarket.diamonds.repository.DiamondRepository;
import com.mongodb.MongoException;

@Service
public class DiamondService {

	@Autowired
	private DiamondRepository diamondRepository;
	
	public List<Diamond> getAllDiamonds() throws Exception {
		
		List<Diamond> diamondlist =  new ArrayList<>();
		
		try {
			List<Supplier> list = diamondRepository.findAll();
			for(Supplier s: list)
				diamondlist.addAll(s.getDiamonds());
			if(diamondlist.size()==0)
				throw new Exception("Currently there are no diamonds to Display");
		}
		catch (MongoException exception) {
				throw new Exception("There is some network issue, Please try after some time");		
		}
		catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
		return diamondlist;
	}

	public Supplier addDiamonds(ArrayList<Diamond> list, String id) throws Exception {
		Supplier supplier = new Supplier();
		supplier.set_id(id);
		supplier.setDiamonds(list);
		Supplier supplier1;
		try {
			 supplier1= diamondRepository.save(supplier);
		}
		catch (MongoException exception) {
			throw new Exception("There is some network issue, Please try after some time");		
		}
		catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
			
		return supplier1;
	}

	public void deleteSupplier(String supplierId) throws Exception {
		
		try {
			if(diamondRepository.findOne(supplierId)==null)
				throw new Exception("invalid Supplier ID");
			diamondRepository.delete(supplierId);
		}
		catch (MongoException exception) {
			throw new Exception("There is some network issue, Please try after some time");		
		}
		catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	public List<Diamond> getAllDiamondsForSupplier(String supplierId) throws Exception {
		
		List<Diamond> diamondlist =  new ArrayList<>();
		
		try {
			Supplier supplier = diamondRepository.findOne(supplierId);
			if (supplier==null) {
				throw new Exception("Invalid Supplier ID");
			}
			diamondlist.addAll(supplier.getDiamonds());
			if(diamondlist.size()==0)
				throw new Exception("Currently there are no Diamonds in your Bucket");
		}
		catch (MongoException exception) {
				throw new Exception("There is some network issue, Please try after some time");		
		}
		catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
		return diamondlist;

	}

}
