package br.com.foursys.locadora.util;

import java.util.Calendar;

public class Data {

	public static String pegarDataAtual() {
		Calendar cal = Calendar.getInstance();
		int anoAtual = cal.get(Calendar.YEAR);
		int mesAtual = cal.get(Calendar.MONTH) + 1;
		int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
		int horaAtual = cal.get(Calendar.HOUR);
		int minutoAtual = cal.get(Calendar.MINUTE);
		int segundoAtual = cal.get(Calendar.SECOND);
		int milissegundoAtual = cal.get(Calendar.MILLISECOND);
		String strData = anoAtual + "-" + mesAtual + "-" + diaAtual + " " + horaAtual + ":" + minutoAtual + ":"
				+ segundoAtual + "." + milissegundoAtual;
		return strData;
	}
	
	public static String formataData(String data) {
		String dataLocacao = "";
		String[] dataFormatada = null;
		dataLocacao = data;
		dataLocacao = data.substring(0, 8).replace("-", "/");
		dataFormatada = dataLocacao.split("/");
		
		return dataFormatada[2]+"/"+dataFormatada[1]+"/"+dataFormatada[0];
	}
	
	

}
