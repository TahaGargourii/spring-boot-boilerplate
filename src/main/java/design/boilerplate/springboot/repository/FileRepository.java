package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.File;
import design.boilerplate.springboot.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File, Long> {


	List<File> findByFileName(boolean FileName);
	File findByDateOfUpload (String UpdateDate) ;
	List<File> findByUploadedBy(String UploadedBy) ;
	List<File> findbyField (String Field) ;
	

//	  List<File> findByTitleContaining(String title);
}
