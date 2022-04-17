
package design.boilerplate.springboot.model;
import lombok.*;

import javax.persistence.*;
 

	@Getter
	@Setter
	@Entity
	@NoArgsConstructor
	@AllArgsConstructor
	@Table(name = "FILES")
	public class File {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String fileName;

		private char dateOfUpload;
		
		private String uploadedBy;

		private String Field;
		
		
		
		
		




}
