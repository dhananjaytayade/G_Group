package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.College;
import com.example.demo.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public College saveColege(College college) {
		// TODO Auto-generated method stub
		return collegeRepository.save(college);
	}

	@Override
	public List<College> getAllStudent(College college) {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}

	@Override
	public Optional<College> getCollegeById(int id) {

		return collegeRepository.findById(id);
	}

	@Override
	public Optional<College> deleteByid(int id) {

		Optional<College> colle = collegeRepository.findById(id);

		 
		if (colle.isPresent()) {
			collegeRepository.delete(colle.get());
		
		}
		
		
		return colle;
		
		/*
		 * College colle1= collegeRepository.getById(id);
		 */
		/*
		 * if(colle1!=null) { collegeRepository.delete(colle1); }
		 * 
		 */
	}

	@Override
	public College updateCollege(int id, College newEntity) {

		College availableEntity=collegeRepository.findById(id).get();
		
		if(availableEntity!=null) {
			if(newEntity.getCollegeName()!=null) {
				availableEntity.setCollegeName(newEntity.getCollegeName());
			}
			
			if(newEntity.getCity()!=null) {
				availableEntity.setCity(newEntity.getCity());
			}
			
			collegeRepository.save(availableEntity);
		}
		return availableEntity;
		
	}

	@Override
	public List<College> readByName(String name) {
		// TODO Auto-generated method stub
		return collegeRepository.readByCollegeName(name);
	}

	@Override
	public List<College> readByCollegeName(String name) {
		// TODO Auto-generated method stub
		return collegeRepository.readByCollegeName(name);
	}

	@Override
	public List<College> readByCollegeNameStartsWith(String name) {
		// TODO Auto-generated method stub
		return collegeRepository.readByCollegeNameStartsWith(name);
	}

	@Override
	public List<College> readByRankNoBetween(int start, int end) {
		// TODO Auto-generated method stub
		return collegeRepository.readByRankNoBetween(start, end);
	}

	@Override
	public List<College> listOfCollegeByCity(String name) {
		// TODO Auto-generated method stub
		return collegeRepository.listOfCollegeByCity(name);
	}

	@Override
	public List<College> listOfCollegeByRankNo(String name) {
		// TODO Auto-generated method stub
		return collegeRepository.listOfCollegeByRankNo(name);
	}



}
