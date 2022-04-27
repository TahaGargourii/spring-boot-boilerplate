package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Fond;
import design.boilerplate.springboot.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FondRepository extends JpaRepository<User, Long> {
	
	List<Fond> findByFileName(long id);
	List<Fond> findByAmount (int  amount) ;
	List<Fond> findByCaptable (int captable) ;
	List<Fond> findbyFundedBy(String FundedBy) ;

}

