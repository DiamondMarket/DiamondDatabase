package com.diamondmarket.diamonds.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diamondmarket.diamonds.model.Response;
import com.diamondmarket.diamonds.model.Supplier;

@SuppressWarnings("rawtypes")
public interface DiamondApi {

	
	@RequestMapping(value = "/diamonds/getAll", 
					produces = { "application/json" },
			        method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Response> getAllDiamonds(@RequestHeader HttpHeaders httpHeaders);
	
	@RequestMapping(value = "/supplier/add", 
			produces = { "application/json" },
			consumes = { "application/json" },
	        method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Response> addDiamonds(@RequestHeader HttpHeaders httpHeaders, @RequestBody Supplier supplier);
	
	@RequestMapping(value = "/supplier", 
			produces = { "application/json" },
			consumes = { "application/json" },
	        method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Response> deleteSupplier(@RequestHeader HttpHeaders httpHeaders, @RequestParam("supplierId") String supplierId);
	
	
	
	
	
}
