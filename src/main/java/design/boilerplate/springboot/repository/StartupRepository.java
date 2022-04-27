package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Startup;
import design.boilerplate.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StartupRepository extends JpaRepository<Startup, Long> {

	Startup findByStartupname(String username);

	Startup findByOwner(String owner) ;
	
	boolean existsByEmail(String email);


}
