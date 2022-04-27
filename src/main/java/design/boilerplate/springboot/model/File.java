
package design.boilerplate.springboot.model;
import lombok.*;

import javax.persistence.*;
 

	@Getter
	@Setter
	@Entity
	@NoArgsConstructor
	@Table(name = "FILES")
	public class File {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String fileName;

		private char dateOfUpload;
		
		private String uploadedBy;

		private String field;

		
		
		@Override
		public String toString() {
			return "File [id=" + id + ", fileName=" + fileName + ", dateOfUpload=" + dateOfUpload + ", uploadedBy="
					+ uploadedBy + ", Field=" + field + "]";
		}

		public File(String fileName, char dateOfUpload, String uploadedBy, String field) {
			super();
			this.fileName = fileName;
			this.dateOfUpload = dateOfUpload;
			this.uploadedBy = uploadedBy;
			this.field = field;
		}
		
		


}
