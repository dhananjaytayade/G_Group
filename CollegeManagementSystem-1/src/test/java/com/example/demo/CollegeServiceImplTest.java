package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.College;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.service.CollegeServiceImpl;

@SpringBootTest
public class CollegeServiceImplTest {

	
	@Mock
	CollegeRepository collegeRepository;
	
	@InjectMocks
	CollegeServiceImpl collegeServiceImpl;
	
	
	@Test
	void saveCollegeTest() {
		
		College coll1=new College(11,"Ram","Akola",13);
		when(collegeRepository.save(coll1)).thenReturn(coll1);
		
		assertEquals(coll1, collegeServiceImpl.saveColege(coll1));
	}
	
	@Test
	void getAllStudentTest() {
		List<College> list=new ArrayList<>();
		
		College college=new College(20, "Rohan", "DDDD", 66);
		College college1=new College(21, "Soham", "AAA", 45);
		
		list.add(college);
	
		
		when(collegeRepository.findAll()).thenReturn(list);
		
		assertEquals(list , collegeServiceImpl.getAllStudent(college));
	}
	
	@Test
	void getCollegeByIdTest() {
	
		College collegge1=new College(21, "Soham", "AAA", 45);
		
	Optional<College> coll2=collegeServiceImpl.getCollegeById(21);
		
		when(collegeRepository.findById(21).get()).thenReturn(collegge1);
		
		Optional<College> college12=collegeServiceImpl.getCollegeById(21);
		
		
		assertEquals(21, collegge1.getId());
		assertEquals("Soham", collegge1.getCollegeName());
		assertEquals("AAA", collegge1.getCity());
		assertEquals(45, collegge1.getRankNo());
	/*	
		when(collegeRepository.getById(21)).thenReturn(collegge1);
		
		assertEquals(collegge1, collegeRepository.getById(21));
		
		
	}*/
}
	
	@Test
	void deleteById() {
		College college =new College(5, "SAYALI", "XXX", 15421);
		
		collegeRepository.save(college);
		collegeRepository.deleteById(college.getId());
		 
		Optional<College> actuOptional=collegeRepository.findById(college.getId());
		assertEquals(actuOptional.empty(), actuOptional);
	}
	
}
