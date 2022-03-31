package com.sportyshoes.spring.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.spring.sportyshoes.models.Shoe;
@Repository
public interface ShoeRepository extends JpaRepository<Shoe ,Integer> {

}
