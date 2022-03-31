package com.sportyshoes.spring.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.sportyshoes.spring.sportyshoes.models.PurchaseReport;
import com.sportyshoes.spring.sportyshoes.models.Shoe;
import com.sportyshoes.spring.sportyshoes.sevice.SportyShoesservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CRUDController {
	@Autowired
	private SportyShoesservice sportyshoeService;  
	@PostMapping("/admin/shoe")
	  public ResponseEntity<Shoe> createshoe (@RequestBody Shoe shoe )
	  {
		 try
		 {
              
          return new ResponseEntity<Shoe>(sportyshoeService.createshoe(shoe),HttpStatus.OK);
		 }
		 catch(Exception e)
		 {
		  return new ResponseEntity<Shoe>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<Shoe>(sportyshoeService.getShoeById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Shoe>( HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/admin/shoe")
	public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe) {
		return new ResponseEntity<Shoe>(sportyshoeService.updateShoe(shoe), HttpStatus.OK);
	}
	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			sportyshoeService.DeleteShoeById(id);
			return new ResponseEntity<String>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);
		}
	}
		/* these method  for purchase_report controller*/
		@PostMapping("/admin/purchaseReport")
		public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
			try {
				return new ResponseEntity<PurchaseReport>(sportyshoeService.createPurchaseReport(pr), HttpStatus.OK);
			} catch (Exception e) {
				
				return new ResponseEntity<PurchaseReport>(  HttpStatus.BAD_REQUEST);
			}
		}
		@GetMapping("/admin/purchaseReport/id/{id}")
		public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
			try {
				return new ResponseEntity<PurchaseReport>(sportyshoeService.getPurchaseReportById(id), HttpStatus.OK);
			} catch (Exception e) {
				
				return new ResponseEntity<PurchaseReport>( HttpStatus.NOT_FOUND);
			}
		}
		@PutMapping("/admin/purchaseReport")
		public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr) {
			return new ResponseEntity<PurchaseReport>(sportyshoeService.updatePurchaseReport(pr), HttpStatus.OK);
		}
		@DeleteMapping("/admin/purchaseReport/{id}")
		public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
			try {
				sportyshoeService.deletePurchaseReportById(id);
				return new ResponseEntity<String>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
			} catch (Exception e) {
								return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);
			}
		}



}

