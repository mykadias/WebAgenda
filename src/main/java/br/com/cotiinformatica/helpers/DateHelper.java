package br.com.cotiinformatica.helpers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {

	// m�todo para converter uma data Java para o formato do banco de dados
	public static String formatToString(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		return sdf.format(data);

	}
	// m�todo para converter um valor 'yyyy-MM-dd' para data do java

	public static Date formatToDate(String data) {

		int ano = Integer.parseInt(data.substring(0, 4));
		int mes = Integer.parseInt(data.substring(5, 7));
		int dia = Integer.parseInt(data.substring(8, 10));

		Calendar calendar = new GregorianCalendar(ano, mes - 1, dia);
		return calendar.getTime();

	}

}
