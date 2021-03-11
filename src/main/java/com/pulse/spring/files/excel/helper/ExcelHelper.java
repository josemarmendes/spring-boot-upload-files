package com.pulse.spring.files.excel.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.pulse.spring.files.csv.model.Tutorial;

public class ExcelHelper {
	public static List<Tutorial> criar(InputStream is) {
		List<Tutorial> tutoriais = new ArrayList<>();

		try {

			Workbook workbook = new HSSFWorkbook(is);
			
			// setando a aba
			Sheet sheet = workbook.getSheetAt(0);

			List<Row> rows = (List<Row>) toList(sheet.iterator());

			rows.forEach(row -> {
				List<Cell> cells = (List<Cell>) toList(row.cellIterator());

				Tutorial tutorial = new Tutorial();
				tutorial.setId(cells.get(0).getRowIndex());
				tutorial.setTitulo(cells.get(1).getStringCellValue());
				tutorial.setDescricao(cells.get(2).getStringCellValue());
				tutorial.setPublicacao(cells.get(3).getStringCellValue());

				tutoriais.add(tutorial);

				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			);

		}
		catch (IOException e) {
			throw new RuntimeException("falha ao analisar arquivo: " + e.getMessage());
		}

		return tutoriais;

	}

	public static List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}

	/*
	 * public static boolean hasExcelFormat(MultipartFile file) {
	 * 
	 * if (!TYPE.equals(file.getContentType())) { return false; }
	 * 
	 * return true; }
	 */

}
