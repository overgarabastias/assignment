package com.tsoft.assignment.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proyectoRecurso")
public class ProyectoRecursoTO {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private ProyectoTO proyecto;
	
	@ManyToOne
	private RecursoTO recurso;

	public ProyectoRecursoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProyectoRecursoTO(Integer id, ProyectoTO proyecto, RecursoTO recurso) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.recurso = recurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "ProyectoRecursoTO [id=" + id + ", proyecto=" + proyecto + ", recurso=" + recurso + "]";
	}
	
}
