package com.sportyshoes.spring.sportyshoes.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.spring.sportyshoes.models.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer> {
	public List<PurchaseReport> findByDop(Date dop);
	public List<PurchaseReport> findByCategory(String category);


}
