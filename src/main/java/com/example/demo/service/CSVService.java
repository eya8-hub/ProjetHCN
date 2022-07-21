package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampe.demo.helper.CSVHelper;
import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;

@Service
public class CSVService {

  @Autowired
  TutorialRepository repository;
  
  public ByteArrayInputStream load() {
    List<Tutorial> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }
}
