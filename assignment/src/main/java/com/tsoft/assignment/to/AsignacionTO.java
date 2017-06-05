package com.tsoft.assignment.to;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="asignacion")
public class AsignacionTO {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaFin")
	private Date fechaFin;
	
	@Column(name="localizacion")
	private String localizacion;
	
	@Column(name="imputable")
	private Boolean imputable;
	
	@Column(name="facturable")
	private Boolean facturable;
	
	@ManyToOne
	private ProyectoTO proyecto;
	
	@ManyToOne
	private RecursoTO recurso;

	public AsignacionTO(Integer id, Date fechaInicio, Date fechaFin, String localizacion, Boolean imputable,
			Boolean facturable, ProyectoTO proyecto, RecursoTO recurso) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.localizacion = localizacion;
		this.imputable = imputable;
		this.facturable = facturable;
		this.proyecto = proyecto;
		this.recurso = recurso;
	}

	public AsignacionTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Boolean getImputable() {
		return imputable;
	}

	public void setImputable(Boolean imputable) {
		this.imputable = imputable;
	}

	public Boolean getFacturable() {
		return facturable;
	}

	public void setFacturable(Boolean facturable) {
		this.facturable = facturable;
	}

	public ProyectoTO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoTO proyecto) {
		this.proyecto = proyecto;
	}

	public RecursoTO getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoTO recurso) {
		this.recurso = recurso;
	}

	@Override
	public String toString() {
		return "AsignacionTO [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", localizacion="
				+ localizacion + ", imputable=" + imputable + ", facturable=" + facturable + ", proyecto=" + proyecto
				+ ", recurso=" + recurso + "]";
	}	
}
