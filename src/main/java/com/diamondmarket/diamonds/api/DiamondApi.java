package com.diamondmarket.diamonds.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diamondmarket.diamonds.model.Response;
import com.diamondmarket.diamonds.model.Supplier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-17T15:10:28.385Z")

@Api(value = "diamond", description = "the diamond API")
public interface DiamondApi {

	
	@RequestMapping(value = "/diamonds", 
					produces = { "application/json" },
			        method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Response> getAllDiamonds(@RequestHeader HttpHeaders httpHeaders);
	
	@RequestMapping(value = "/diamonds/{supplierId}", 
			produces = { "application/json" },
	        method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Response> getAllDiamondsforSupplier(@RequestHeader HttpHeaders httpHeaders, @PathVariable("supplierId") String supplierId);
	
	
	@RequestMapping(value = "/supplier", 
			produces = { "application/json" },
			consumes = { "application/json" },
	        method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Response> addDiamonds(@RequestHeader HttpHeaders httpHeaders, @RequestBody Supplier supplier);
	
	@RequestMapping(value = "/supplier", 
			produces = { "application/json" },
	        method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Response> deleteSupplier(@RequestHeader HttpHeaders httpHeaders, @RequestParam("supplierId") String supplierId);
	
	
	
	
	
}
