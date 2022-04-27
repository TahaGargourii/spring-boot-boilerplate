package design.boilerplate.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor 
@Table(name = "FONDS")
public class Fond {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFundedBy() {
		return fundedBy;
	}
	public void setFundedBy(String fundedBy) {
		this.fundedBy = fundedBy;
	}
	public String getCapTable() {
		return capTable;
	}
	public void setCapTable(String capTable) {
		this.capTable = capTable;
	}
	
	public String getFname() {
		return name;
	}
	public void setFname(String fname) {
		name = fname;
	}

	private int amount ;
	private String name ;
	private String fundedBy ; 
	private String capTable ;
	
	
	

}
