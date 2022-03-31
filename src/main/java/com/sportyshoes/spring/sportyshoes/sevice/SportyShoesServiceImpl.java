package com.sportyshoes.spring.sportyshoes.sevice;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException; 
import com.sportyshoes.spring.sportyshoes.models.PurchaseReport;
import com.sportyshoes.spring.sportyshoes.models.Shoe;
import com.sportyshoes.spring.sportyshoes.repository.PurchaseReportRepository;
import com.sportyshoes.spring.sportyshoes.repository.ShoeRepository;
@Service
public class SportyShoesServiceImpl implements SportyShoesservice {
	@Autowired
	private ShoeRepository shoerepository;
	@Autowired
	private PurchaseReportRepository prRepo;
	@PostConstruct
	public void init() {
		Shoe s1 = new Shoe(1,"Shoe Name 1","Basketball",1000.24);
		Shoe s2 = new Shoe(2,"Shoe Name 2","Cricket",1100.24);
		Shoe s3 = new Shoe(3,"Shoe Name 3","Running",900.24);
		Shoe s4 = new Shoe(4,"Shoe Name 4","Football",1900.24);
		
		shoerepository.save(s1);
		shoerepository.save(s2);
		shoerepository.save(s3);
		shoerepository.save(s4);
		Date d = new Date(0);
		PurchaseReport pr1 = new PurchaseReport(5,"user_1","Running",d,"adidas_runner:5,nike_airmax:10");
		PurchaseReport pr2 = new PurchaseReport(6,"user_2","Cricket",d,"adidas_cricket:5,nike_cricket:10");
		PurchaseReport pr3 = new PurchaseReport(7,"user_3","Basketball",d,"adidas_basketball:5,nike_basketball:10");
		PurchaseReport pr4 = new PurchaseReport(8,"user_4","Football",d,"adidas_football:5,nike_football:10");
		
		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
	}


	public Shoe createshoe(Shoe shoe) {
		// TODO Auto-generated method stub
		int id = shoe.getId();
		Shoe oldShoe = null;
		try {
			oldShoe = shoerepository.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoe!=null)
			System.out.println("Shoe already exists with id: \"+id");
		return shoerepository.save(shoe);
		

	}


	public Shoe getShoeById(int id) {
		// TODO Auto-generated method stub
		
			Shoe shoe = null;
			try {
				if(id<=0) //throw new BusinessException("Shoe Id can not be negative or zero");
				shoe = shoerepository.findById(id).get();
			}catch(NoSuchElementException e) {
				
			}
			return shoe;
		}


	public Shoe updateShoe(Shoe shoe) {
		// TODO Auto-generated method stub
					return shoerepository.save(shoe);
		}


	public void DeleteShoeById(int id) throws Exception  {
		// TODO Auto-generated method stub
		try {
			try {
				shoerepository.deleteById(id);
			}catch(Exception e) {
				throw new Exception("Invalid id: "+id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public PurchaseReport createPurchaseReport(PurchaseReport pr) {
		// TODO Auto-generated method stub
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) 
			System.out.println("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	

	}


	public PurchaseReport getPurchaseReportById(int id) throws Exception {
		// TODO Auto-generated method stub
		PurchaseReport pr = null;
		try {
			if(id<=0) throw new Exception("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			System.out.println("Purchase Report not found with Id: "+id);
		}
		return pr;
	}


	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		// TODO Auto-generated method stub
			return prRepo.save(pr);
		
	}


	public void deletePurchaseReportById(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new Exception("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<Shoe> getAllShoes() {
		// TODO Auto-generated method stub
		return shoerepository.findAll();
	}


	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		// TODO Auto-generated method stub
		return prRepo.findByCategory(category);
	}


	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		// TODO Auto-generated method stub
		return prRepo.findByDop(dop);
	}


	public List<PurchaseReport> getAllPurchaseReports() {
		// TODO Auto-generated method stub
		return prRepo.findAll();
	}
	}
	


