package com.pulse.spring.files.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pulse.spring.files.csv.message.ResponseMessage;
import com.pulse.spring.files.csv.service.ExcelService;

//@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/excel")
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;

	String message = "";

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> save(@RequestParam("file") MultipartFile file) {

		/* if (ExcelHelper.hasExcelFormat(file)) { */
		try {
			excelService.save(file);
			message = "Upload do arquivo realizado com sucesso: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

		} catch (Exception e) {
			message = "Nao foi possível fazer o upload do arquivo: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

		}

		// }
		//message = "Por favor faça upload de um arquivo excel!";
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
}
