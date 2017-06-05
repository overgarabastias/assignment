package com.tsoft.assignment.to;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="centroCosto")
public class CentroCostoTO{
	

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	private ClienteTO cliente;

	public CentroCostoTO(Integer id, String nombre, ClienteTO cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cliente = cliente;
	}

	public CentroCostoTO() {
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

	public ClienteTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTO cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CentroCostoTO [id=" + id + ", nombre=" + nombre + ", cliente=" + cliente + "]";
	}
	
	

}
