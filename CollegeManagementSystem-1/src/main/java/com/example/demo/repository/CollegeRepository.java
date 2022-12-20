package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.College;

public interface CollegeRepository extends JpaRepositoryImplementation<College, Integer> {
	
	 List<College> readByCollegeName(String name);
	 
	 List<College> readByCollegeNameStartsWith(String name);
	 
	 //rank between
	 List<College> readByRankNoBetween(int start,int end);
	 
	 //native Query
	 
		@Query(value = "select * from college3 where city=:n",nativeQuery = true)
		List<College> listOfCollegeByCity(@Param("n") String name);

		//JPQL
		@Query("select e  from College e where e.rankNo=n")
		List<College> listOfCollegeByRankNo(@Param("n")String name );
}
