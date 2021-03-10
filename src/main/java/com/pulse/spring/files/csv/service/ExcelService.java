package com.pulse.spring.files.csv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pulse.spring.files.csv.model.Tutorial;
import com.pulse.spring.files.csv.repository.TutorialRepository;
import com.pulse.spring.files.excel.helper.ExcelHelper;

@Service
public class ExcelService {

	@Autowired
	private TutorialRepository repository;

	public void save(MultipartFile file) {
		try {
			List<Tutorial> tutorials = ExcelHelper.criar(file.getInputStream());
			repository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public List<Tutorial> getAllTutorials() {
		return repository.findAll();
	}

}
