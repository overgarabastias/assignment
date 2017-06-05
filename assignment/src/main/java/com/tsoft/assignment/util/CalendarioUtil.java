package com.tsoft.assignment.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author omar.vergara
 *
 *	Clase para obtener distintas funcionalidades de la fecha
 */
public class CalendarioUtil{
	

	/**
	 * Obtener primer dia del mes segun un a�o y un mes
	 * @param a�o
	 * @param mes
	 * @return retorna un date correspondiente al primer dia del mes
	 */
	public Date PrimerDiaMes(int annio, int mes){
		Calendar cal = setCalendar(annio, mes);
		return cal.getTime();
	}
	
	/**
	 * obtener ultimo dia del mes segun a�o y mes
	 * @param a�o
	 * @param mes
	 * @return retorna un date correspondiente al ultimo dia del mes
	 */
	public Date UltimoDiaMes(int annio, int mes){
		Calendar cal = setCalendar(annio, mes);
		return new GregorianCalendar(annio, mes - 1, cal.getActualMaximum(Calendar.DAY_OF_MONTH)).getTime();
	}
	
	private Calendar setCalendar(int annio, int mes){
		return new GregorianCalendar(annio, mes - 1, 1);
	}

}
