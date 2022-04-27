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

import design.boilerplate.springboot.model.Fond;
import design.boilerplate.springboot.repository.FondRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FondController {

	@Autowired
	FondRepository fondRepository;
	@GetMapping("/files")
	public ResponseEntity<List<Fond>> getAllFonds(@RequestParam(required = false) String title) {
		try {
			List<Fond> fonds = new ArrayList<Fond>();

			if (title == null)
				fondRepository.findAll().forEach(fonds::add);
			
//				fileRepository.findByTitleContaining(title).forEach(files::add);

			if (fonds.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fonds, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<Fond> getFileById(@PathVariable("id") long id) {
		Optional<Fond> fileData = fondRepository.findById(id);

		if (fileData.isPresent()) {
			return new ResponseEntity<>(fileData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/files")
	public ResponseEntity<Fond> createFile(@RequestBody Fond fond) {
		try {
			Fond _file = fondRepository
					.save(new Fond(fond.getAmount(), fond.getCapTable(),fond.getFundedBy() )));
			return new ResponseEntity<>(_file, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/files/{id}")
	public ResponseEntity<Fond> updateFond(@PathVariable("id") long id, @RequestBody Fond fond) {
		Optional<Fond> fileData = fondRepository.findById(id);

		if (fileData.isPresent()) {
			Fond fond = fondData.get();
			fond.setAmount(amount);fond.getAmount());
			fond.setCapTable(capTable) ;(fond.getCapTable());
			fond.setFundedBy(fundedBy);(fond.getFundedBy());
			
			return new ResponseEntity<>(fondRepository.save( fond), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/fond/{id}")
	public ResponseEntity<HttpStatus> deletefond(@PathVariable("id") long id) {
		try {
			fondRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/fonds")
	public ResponseEntity<HttpStatus> deleteAllfonds() {
		try {
			fondRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/fonds/published")
	public ResponseEntity<List<Fond>> findByPublished() {
		try {
			List<Fond> fond = fondRepository.findByFondAmount (true);

			if (fond.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(fond, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}



