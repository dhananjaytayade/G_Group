package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interceptors.RecordNotFoundException;
import com.example.demo.model.College;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CollegeController.class);
 
	@Autowired
	private CollegeService collegeService;

	@Autowired
	private CollegeRepository collegeRepository;

	@PostMapping("/save")

	public ResponseEntity<College> saveCollege(@RequestBody College college) {

		logger.info("Inside saveCollege Method...");

		College coll = collegeService.saveColege(college);
		return ResponseEntity.ok().body(coll);
	}

	@GetMapping("/getAll")
	public List<College> getAllStudent(College college) {
		return collegeService.getAllStudent(college);

	}

	@GetMapping("/getBy")

	public Optional<College> getCollegeById(@RequestParam (value = "id") int id) {

		logger.debug("Request ID: {} ", id);

		Optional<College> college = collegeService.getCollegeById(id);

		/*
		 * if (college.isPresent()) { return new ResponseEntity<>(college.get(),
		 * HttpStatus.OK); } else { return new ResponseEntity<>(null,
		 * HttpStatus.NOT_FOUND); }
		 */
		return collegeService.getCollegeById(id);

	}

	@DeleteMapping("/delete/{id}")
	public /* ResponseEntity<College> */ void deleteByid(@PathVariable("id") int id) {

		if (!collegeRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}

		/*
		 * Optional<College> coll2 = collegeService.deleteByid(id); if
		 * (coll2.isPresent()) { return new ResponseEntity<>(HttpStatus.OK); } else {
		 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */

	}

	@PutMapping("update/{id}")
	public ResponseEntity<College> updateCollege(@PathVariable("id") int id, @RequestBody College college) {

		logger.info("ID: {} Request: {}", id, college);

		College college2 = collegeService.updateCollege(id, college);

		if (collegeRepository.existsById(id)) {
			return new ResponseEntity<>(college2, HttpStatus.OK);
		}

		/*
		 * if(college2!=null) { return new ResponseEntity<>(college2, HttpStatus.OK); }
		 */
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("readByName/{name}")
	public List<College> readByCollegeName(@PathVariable("name") String name) {
		return collegeService.readByCollegeName(name);

	}

	@GetMapping("readByStarts/{name}")

	public List<College> readByCollegeNameStartsWith(@PathVariable("name") String name) {
		return collegeService.readByCollegeNameStartsWith(name);
	}

	@GetMapping("readByRank/{start}/{end}")
	List<College> readByRankNoBetween(@PathVariable("start") int start, @PathVariable("end") int end) {
		return collegeService.readByRankNoBetween(start, end);

	}
	// native query

	@GetMapping("/listofcollege/{name}")
	public List<College> listOfCollegeByCity(@PathVariable("name") String name) {

		return collegeService.listOfCollegeByCity(name);

	}

	// JPQL query
	@GetMapping("/byjpql/{name}")
	List<College> listOfCollegeByRankNo(@PathVariable("name") String name) {
		return collegeService.listOfCollegeByRankNo(name);

	}
}
