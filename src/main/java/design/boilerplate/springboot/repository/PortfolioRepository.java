package design.boilerplate.springboot.repository;


import design.boilerplate.springboot.model.Portfolio;
import design.boilerplate.springboot.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	
  Portfolio findById (int id) ;
  List <Portfolio> findBySize (float size) ;
  
	
}
