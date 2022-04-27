package design.boilerplate.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.model.File;
import design.boilerplate.springboot.repository.FileRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	FileRepository fileRepository;
	@GetMapping("/files")
	public ResponseEntity<List<File>> getAllFiles(@RequestParam(required = false) String title) {
		try {
			List<File> files = new ArrayList<File>();

			if (title == null)
				fileRepository.findAll().forEach(files::add);
			
//				fileRepository.findByTitleContaining(title).forEach(files::add);

			if (files.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(files, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<File> getFileById(@PathVariable("id") long id) {
		Optional<File> fileData = fileRepository.findById(id);

		if (fileData.isPresent()) {
			return new ResponseEntity<>(fileData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/files")
	public ResponseEntity<File> createFile(@RequestBody File file) {
		try {
			File _file = fileRepository
					.save(new File(file.getFileName(), file.getDateOfUpload(),file.getUploadedBy(),file.getField()));
			return new ResponseEntity<>(_file, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/files/{id}")
	public ResponseEntity<File> updateFile(@PathVariable("id") long id, @RequestBody File file) {
		Optional<File> fileData = fileRepository.findById(id);

		if (fileData.isPresent()) {
			File _file = fileData.get();
			_file.setFileName(file.getFileName());
			_file.setDateOfUpload(file.getDateOfUpload());
			_file.setUploadedBy(file.getUploadedBy());
			_file.setField(file.getField());
			return new ResponseEntity<>(fileRepository.save(_file), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/files/{id}")
	public ResponseEntity<HttpStatus> deleteFile(@PathVariable("id") long id) {
		try {
			fileRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/files")
	public ResponseEntity<HttpStatus> deleteAllFiles() {
		try {
			fileRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/files/published")
	public ResponseEntity<List<File>> findByPublished() {
		try {
			List<File> files = fileRepository.findByFileName(true);

			if (files.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(files, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}



