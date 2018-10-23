package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.person;
import com.example.demo.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepo personrepo;

/*	public void readdata() {

		FileInputStream fis=null;
		
		try {
			PrintStream o;
			o = new PrintStream(new File("alldata.txt"));
			PrintStream console = System.out;
			System.setOut(o);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		try {
			fis = new FileInputStream("mongo.txt");
			int data = 0;
			while((data= fis.read()) != -1)
			{
						
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}*/

	@Override
	public void insertData() {
		
		
		personrepo.deleteAll();
		
		File dir = new File("files");

		for (File f : dir.listFiles())
		{
			try {
				StringBuilder sb = new StringBuilder();
			    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			    String line = null;
			    int cnt=0;
			    while( (line = br.readLine())!= null ){
			    	
			    	 cnt++;
			        personrepo.save(new person(f.getName(),cnt,line));
			       
			    }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public List<person> getAll()
	{
		return personrepo.findAll();
	}
	
	public List<person> getByWord(String word)
	{
		return personrepo.findByWord(word);
	}

	public List<person> getByLineNum(int lno) {
		// TODO Auto-generated method stub
		return personrepo.findByLno(lno);
	}
	
	

	
}
