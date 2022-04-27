package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Startupper;
import design.boilerplate.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StartupperRepository extends JpaRepository<Startupper, Long> {

	Startupper findByname(String username);
	Startupper findById(int id) ;
	Startupper fundByStartupName (String Startup_Name) ;
	

	boolean existsByEmail(String email);

	boolean existsByName(String username);

}
