package com.example.demo.controller;

import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.person;
import com.example.demo.service.PersonServiceImpl;

@RestController
public class PersonController {

	
	@Autowired
	private PersonServiceImpl personservice;
	
	@RequestMapping("/insert")
	public void rw()
	{
		personservice.insertData();
		
	}
	
	@RequestMapping("/getAll")
	public List<person> getAll()
	{
		return personservice.getAll();
	}
	@RequestMapping("/{key}")
	public List<person> getByWord(@PathVariable("key") String key )
	{
		return personservice.getByWord(key);
	}
	/*@RequestMapping("/{linenum}")
	public List<person> getByLineNum(int lno)
	{
		return personservice.getByLineNum(lno);
	}*/
}
