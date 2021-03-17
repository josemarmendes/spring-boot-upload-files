package com.pulse.spring.files.csv.helper;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pulse.spring.files.csv.model.PrevisaoInventario;

public class LerArquivoTxtHelper {

	public static List<PrevisaoInventario> montaObjetoDeArquivoTxt(InputStream file) {

		Scanner scanner = new Scanner(file, "UTF-8");
		scanner.useDelimiter(",");

		List<PrevisaoInventario> previsaoInventarios = new ArrayList<>();

		while (scanner.hasNext()) {
			String linha = scanner.nextLine();
			if (linha != null && !linha.trim().isEmpty()) {
				linha = linha.replaceAll("\"", "");
				String dados[] = linha.split("\\,");

				PrevisaoInventario previsaoInventario = new PrevisaoInventario();
				previsaoInventario.setAno(Integer.valueOf(dados[0]));
				previsaoInventario.setMes(Integer.valueOf(dados[1]));
				previsaoInventario.setModalidade(dados[2]);
				previsaoInventario.setIdFilial(3);
				previsaoInventario.setIdSetor(Integer.valueOf(dados[4]));
				previsaoInventario.setFrequencia(Integer.valueOf(dados[5]));

				previsaoInventarios.add(previsaoInventario);
				
			}
		}

		return previsaoInventarios;

	}

}
