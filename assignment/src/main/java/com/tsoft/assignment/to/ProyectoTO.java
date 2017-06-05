package com.tsoft.assignment.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class ProyectoTO {
		
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	private CentroCostoTO centroCosto;

	public ProyectoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProyectoTO(Integer id, String nombre, CentroCostoTO centroCosto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.centroCosto = centroCosto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CentroCostoTO getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(CentroCostoTO centroCosto) {
		this.centroCosto = centroCosto;
	}

	@Override
	public String toString() {
		return "ProyectoTO [id=" + id + ", nombre=" + nombre + ", centroCosto=" + centroCosto + "]";
	}

}
