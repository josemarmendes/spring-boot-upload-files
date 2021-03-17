package com.pulse.spring.files.csv.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pulse.spring.files.csv.helper.CSVHelper;
import com.pulse.spring.files.csv.helper.LerArquivoTxtHelper;
import com.pulse.spring.files.csv.model.PrevisaoInventario;
import com.pulse.spring.files.csv.model.Tutorial;
import com.pulse.spring.files.csv.repository.PrevisaoInventarioRepository;
import com.pulse.spring.files.csv.repository.TutorialRepository;

@Service
public class CSVService {

	@Autowired
	private TutorialRepository repository;
	
	@Autowired
	private PrevisaoInventarioRepository repositoryInventario;

	public void salvarArquivo(MultipartFile file) {
		try {
			List<Tutorial> tutorials = CSVHelper.montaObjetoDeUmArquivoCsv(file.getInputStream());
			repository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
	
	public void salvarArquivoTxt(MultipartFile file) throws IOException {
		try {
			List<PrevisaoInventario> lista = LerArquivoTxtHelper.montaObjetoDeArquivoTxt(file.getInputStream());
			repositoryInventario.saveAll(lista);
		
		} catch (IOException e) {
			throw new RuntimeException("falha ao tentar salvar os dados do arquivo: " + e.getMessage());
		}
	
	}

	public ByteArrayInputStream load() {
		List<Tutorial> tutorials = repository.findAll();

		ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
		return in;
	}

	public List<Tutorial> getAllTutorials() {
		return repository.findAll();
	}
}
