package com.sportyshoes.spring.sportyshoes.sevice;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.sportyshoes.spring.sportyshoes.models.PurchaseReport;
import com.sportyshoes.spring.sportyshoes.models.Shoe;
public interface SportyShoesservice {
	public  Shoe createshoe (Shoe shoe);
	public Shoe getShoeById(int id);
	public Shoe updateShoe(Shoe shoe);
	public void DeleteShoeById(int id) throws Exception;
	public PurchaseReport createPurchaseReport(PurchaseReport pr) ;
	public PurchaseReport getPurchaseReportById(int id) throws Exception;
	public PurchaseReport updatePurchaseReport(PurchaseReport pr);
	public void deletePurchaseReportById(int id) throws Exception;
	public List<Shoe> getAllShoes();
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category);
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop);
	public List<PurchaseReport> getAllPurchaseReports();
    
}
