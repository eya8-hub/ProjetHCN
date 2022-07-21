package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampe.demo.helper.CSVMetrologieHelper;
import com.example.demo.model.Métrologie;
import com.example.demo.repository.MetrologieRepository;
@Service
public class CSCMetrologieService {
	
	

	  @Autowired
	 MetrologieRepository metrologieRepository;
	  
	 
	

	
	 public ByteArrayInputStream load() {
		    List<Métrologie> metrologies = metrologieRepository.findAll();

		    ByteArrayInputStream in = CSVMetrologieHelper.tutorialsToCSV(metrologies);
		    return in;
		  }
		


}