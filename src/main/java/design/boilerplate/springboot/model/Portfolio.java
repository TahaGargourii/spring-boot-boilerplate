package design.boilerplate.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor 
@Table(name = "PORTFOLIO")
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private int size ;
	

}