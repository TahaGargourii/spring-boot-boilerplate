package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "INVESTORS")
public class Investor {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String name;

		@Column(unique = true)
		private String username;

		private String password;

		private String email;
		
		private String investingStages;
		
	    private int ticketSize ;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getInvestingStages() {
			return investingStages;
		}

		public void setInvestingStages(String investingStages) {
			this.investingStages = investingStages;
		}

		public int getTicketSize() {
			return ticketSize;
		}

		public void setTicketSize(int ticketSize) {
			this.ticketSize = ticketSize;
		}
	    
	    

}
