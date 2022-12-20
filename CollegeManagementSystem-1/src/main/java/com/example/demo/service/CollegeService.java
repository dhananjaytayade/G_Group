package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.College;

public interface CollegeService {

	public College saveColege(College college);

	public List<College> getAllStudent(College college);

	public Optional<College> getCollegeById(int id);

	public Optional<College> deleteByid(int id);
	
	public College updateCollege(int id, College college);
	
	public List<College> readByName(String name);

	List<College> readByCollegeName(String name);
	
	 List<College> readByCollegeNameStartsWith(String name);
	 
	 List<College> readByRankNoBetween(int start,int end);
	 
	 //native Query
	 List<College> listOfCollegeByCity( String name);
	 
	 //JPQL
	 List<College> listOfCollegeByRankNo(String name);

}
