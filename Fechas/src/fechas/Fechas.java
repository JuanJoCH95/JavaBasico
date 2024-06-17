package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Fechas {

	public static void main(String[] args) {
		/*
		Scanner Leer = new Scanner(System.in);
		GregorianCalendar calendar = new GregorianCalendar();
		int anio, mes, dia;

		System.out.print("Ingrese día: ");
		dia = Leer.nextInt();
		
		System.out.print("Ingrese mes: ");
		mes = Leer.nextInt();
		
		System.out.print("Ingrese año: ");
		anio = Leer.nextInt();
		
		if((calendar.isLeapYear(anio) && mes == 2 && dia > 29) || (!calendar.isLeapYear(anio) && dia > 31) || mes > 12) {
			System.out.println("Fecha NO valida");
		} else {
			System.out.println("La fecha es: " + dia + "/" + mes + "/" + anio);
		}
		
		
		//Codigo para mostrar la hora en hora militar y la fecha actual con hora
		Calendar calendario = Calendar.getInstance();
		int hora;
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		
		String horaInicio = String.valueOf(hora);
		
		System.out.println("La hora es: " + horaInicio);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHora = dtf.format(LocalDateTime.now());
		System.out.println("Hoy es: " + fechaHora);*/
		
		//Codigo para convertir un String a Date
		try {
			Date fechaActual = new Date();
			String fechaString = "01/01/2024";
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaDate = formato.parse(fechaString);
			
			String fechaString2 = "01/01/2021";
			Date fechaDate2 = formato.parse(fechaString2);
			
			System.out.println("La fecha del comparendo es: " + fechaActual);
			System.out.println("La fecha del parametro es: " + fechaDate);
			
			if(fechaActual.compareTo(fechaDate) >= 0 && fechaDate2.compareTo(fechaDate) < 0) {
				System.out.println("Si se puede");
			}
			
			/* long diff = fechaActual.getTime() - fechaDate.getTime();
			TimeUnit time = TimeUnit.DAYS;
			long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
			
			System.out.println("La fecha actual es: " + fechaActual);
			System.out.println(fechaDate);
			System.out.println("La diferencia entre las fechas es: " + diferencia); */
		} catch (ParseException ex) {
			System.out.println(ex);
		}
	}
}
