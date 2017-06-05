package com.tsoft.assignment.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class PerfilTO {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;

	public PerfilTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public PerfilTO() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "PerfilTO [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
