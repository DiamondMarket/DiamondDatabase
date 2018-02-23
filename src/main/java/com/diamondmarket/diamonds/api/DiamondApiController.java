package com.diamondmarket.diamonds.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.diamondmarket.diamonds.model.Diamond;
import com.diamondmarket.diamonds.model.Error;
import com.diamondmarket.diamonds.model.Response;
import com.diamondmarket.diamonds.model.Supplier;
import com.diamondmarket.diamonds.model.TransactionContext;
import com.diamondmarket.diamonds.service.DiamondService;

@RestController
public class DiamondApiController implements DiamondApi {

	@Autowired
	private DiamondService diamondService;

	
	@Override
	public ResponseEntity<Response> getAllDiamonds(@RequestHeader HttpHeaders httpHeaders) {
		
		TransactionContext context = createTransactionContext(httpHeaders);
		List<Diamond> list=null;
		try {
			list = diamondService.getAllDiamonds();
		} 
		catch (Exception exception) {
			return errorResponse(context, exception, HttpStatus.BAD_REQUEST);
		}
		return successResponse(context, list, HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<Response> getAllDiamondsforSupplier(@RequestHeader HttpHeaders httpHeaders, @PathVariable("supplierId") String supplierId) {
		
		TransactionContext context = createTransactionContext(httpHeaders);
		List<Diamond> list=null;
		try {
			list = diamondService.getAllDiamondsForSupplier(supplierId);
		} 
		catch (Exception exception) {
			return errorResponse(context, exception, HttpStatus.BAD_REQUEST);
		}
		return successResponse(context, list, HttpStatus.OK);
	}



	@Override
	public ResponseEntity<Response> addDiamonds(@RequestHeader HttpHeaders httpHeaders, @RequestBody Supplier supplier) {
		TransactionContext context = createTransactionContext(httpHeaders);
		Supplier supplier2;
		try {
			supplier2 = diamondService.addDiamonds(supplier.getDiamonds(),supplier.get_id());
		} catch (Exception exception) {
			return errorResponse(context, exception, HttpStatus.BAD_REQUEST);
		}
		return successResponse(context, supplier2 , HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<Response> deleteSupplier(@RequestHeader HttpHeaders httpHeaders, String supplierId) {
		TransactionContext context = createTransactionContext(httpHeaders);
		try {
			diamondService.deleteSupplier(supplierId);
		} catch (Exception exception) {
			return errorResponse(context, exception, HttpStatus.BAD_REQUEST);
		}
		return successResponse(context, "Supplier Deleted Successfully", HttpStatus.OK);
	}
	
	private TransactionContext createTransactionContext(HttpHeaders httpHeaders) {

		TransactionContext context = new TransactionContext();
		if(httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());	
		} else {
			context.setCorrelationId("demo");
		}
		if(httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		
		return context;
	}

	private ResponseEntity<Response> successResponse(TransactionContext context, Object object, HttpStatus httpStatus){
		HttpHeaders headers = setHeaders(context);
		Response response = new Response();
		response.setData(object);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers , httpStatus);
		return responseEntity;
	}
	
	private HttpHeaders setHeaders(TransactionContext context) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("ApplicationLabel", context.getApplicationLabel());
		headers.add("Content-Type", "application/json");
		return headers;
	}


	private ResponseEntity<Response> errorResponse(TransactionContext context, Exception exception, HttpStatus httpStatus){
		HttpHeaders headers = setHeaders(context);
		Error error = new Error();
		error.setCode(httpStatus.toString() + "0001");
		error.setReason(exception.getMessage());
		Response response = new Response();
		response.setError(error);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;
	}

}
