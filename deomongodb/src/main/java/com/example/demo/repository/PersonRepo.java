package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.person;

public interface PersonRepo  extends MongoRepository<person, String>{
	

	public List<person> findByWord(String word);
	public List<person> findByLno(int lno);

}
