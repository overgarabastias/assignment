package com.tsoft.assignment.to;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="cliente")
public class ClienteTO {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	public ClienteTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Column(name="nombre")
	private String nombre;

	public ClienteTO() {
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
		return "ClienteTO [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
