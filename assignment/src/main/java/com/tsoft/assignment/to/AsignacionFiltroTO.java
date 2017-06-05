package com.tsoft.assignment.to;

import java.util.Date;

public class AsignacionFiltroTO {
	
	private Integer tipo;
	private RecursoTO recurso;
	private Integer mes;
	private Integer annio;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	
	public AsignacionFiltroTO(Integer tipo, RecursoTO recurso, Integer mes, Integer annio, Date fechaInicio,
			Date fechaFin) {
		super();
		this.tipo = tipo;
		this.recurso = recurso;
		this.mes = mes;
		this.annio = annio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	

	public AsignacionFiltroTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RecursoTO getRecurso() {
		return recurso;
	}
	
	public void setRecurso(RecursoTO recurso) {
		this.recurso = recurso;
	}
	
	public Integer getMes() {
		return mes;
	}
	
	/**
	 * Entrega un identificador del mes que se quiere filtrar:
	 * 
	 * @return <ul> 
	 * 				<li>1 : Enero
	 * 		   		<li>2 : Febrero
	 * 				<li>3 : Marzo
	 * 				<li>4 : Abril
	 * 				<li>5 : Mayo
	 * 		   		<li>6 : Junio
	 * 				<li>7 : Julio
	 * 				<li>8 : Agosto
	 * 				<li>9 : Septiembre
	 * 		   		<li>10 : Octubre
	 * 				<li>11 : Noviembre
	 * 				<li>12 : Diciembre
	 * 		   </ul>
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	/**
	 * Setea un identificador del mes que se quiere filtrar:
	 * 
	 * @return <ul> 
	 * 				<li>1 : Enero
	 * 		   		<li>2 : Febrero
	 * 				<li>3 : Marzo
	 * 				<li>4 : Abril
	 * 				<li>5 : Mayo
	 * 		   		<li>6 : Junio
	 * 				<li>7 : Julio
	 * 				<li>8 : Agosto
	 * 				<li>9 : Septiembre
	 * 		   		<li>10 : Octubre
	 * 				<li>11 : Noviembre
	 * 				<li>12 : Diciembre
	 * 		   </ul>
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getAnnio() {
		return annio;
	}

	public void setAnnio(Integer annio) {
		this.annio = annio;
	}
	
	/**
	 * Entrega el tipo de filtro a realizar:
	 * 
	 * @return <ul> 
	 * 				<li>1 : filtrado por recurso, mes y a�o</li>
	 * 		   		<li>2 : filtrado por recurso, fecha inicio y fecha fin</li>
	 * 		   </ul>
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * Setear el tipo de filtro a realizar:
	 * 
	 * @return <ul> 
	 * 				<li>1 : filtrado por recurso, mes y a�o</li>
	 * 		   		<li>2 : filtrado por recurso, fecha inicio y fecha fin</li>
	 * 		   </ul>
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "AsignacionFiltroTO [tipo=" + tipo + ", recurso=" + recurso + ", mes=" + mes + ", annio=" + annio
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}
