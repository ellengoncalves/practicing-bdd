package com.everis.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private static final String LOCAL_PROPERTIES = "local.properties";

	private Config() {
	}

	public static String obter(String propriedade, String variavelAmbiente) {
		String valor = System.getProperty(propriedade);
		if (estaVazio(valor)) {
			valor = System.getenv(variavelAmbiente);
		}
		if (estaVazio(valor)) {
			valor = obterDeArquivoLocal(propriedade);
		}
		if (estaVazio(valor)) {
			throw new IllegalStateException("Informe " + propriedade + " nas VM options, variavel de ambiente " + variavelAmbiente + " ou " + LOCAL_PROPERTIES);
		}
		return valor;
	}

	private static String obterDeArquivoLocal(String propriedade) {
		Properties properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream(LOCAL_PROPERTIES)) {
			properties.load(fileInputStream);
			return properties.getProperty(propriedade);
		} catch (IOException e) {
			return null;
		}
	}

	private static boolean estaVazio(String valor) {
		return valor == null || valor.trim().isEmpty();
	}
}
