package design.boilerplate.springboot.model;
import lombok.*;

import javax.persistence.*;
 

	@Getter
	@Setter
	@Entity
	@NoArgsConstructor
	@AllArgsConstructor
	@Table(name = "TEAMS")
	public class Team {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String name;

		private String Members;

		private String Field;
		
		
		
		
		




}
