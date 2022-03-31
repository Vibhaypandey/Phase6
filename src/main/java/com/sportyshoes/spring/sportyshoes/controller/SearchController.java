package com.sportyshoes.spring.sportyshoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.spring.sportyshoes.models.PurchaseReport;
import com.sportyshoes.spring.sportyshoes.models.Shoe;
import com.sportyshoes.spring.sportyshoes.sevice.SportyShoesservice;

@RestController
public class SearchController {
	@Autowired
	private SportyShoesservice sportyshoeService;
	
	/**
	 * Shoe search controller
	 * @return all shoe list
	 */
	
	@GetMapping("/admin/shoe/all")
	public ResponseEntity<List<Shoe>> getAllShoes(){
		return new ResponseEntity<List<Shoe>>(sportyshoeService.getAllShoes(), HttpStatus.OK);
	}
	
	
	/**
	 * Purchase Report Search Controller
	 * @param category
	 * @return purchase reports filtered by the category
	 */
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(sportyshoeService.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	
	/**
	 * Purchase Report Search Controller
	 * @param dateInMs
	 * @return purchase reports filtered by date of purchase(in millisecond time)
	 */
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByDop(@PathVariable Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<PurchaseReport>>(sportyshoeService.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	
	/**
	 * Purchase Report Search Controller
	 * @return all purchase reports
	 */
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(sportyshoeService.getAllPurchaseReports(), HttpStatus.OK);
	}
	}


