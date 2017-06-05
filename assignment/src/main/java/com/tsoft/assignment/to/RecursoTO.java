package com.tsoft.assignment.to;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/***
 * 
 * @author omar.vergara
 * 21-04-2017
 * Objeto con los atributos correspondiente a un recurso
 */
@Entity
@Table(name= "recurso")
public class RecursoTO {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dinamico")
	private Boolean dinamico;
	
	@ManyToOne
	private PerfilTO perfil;

	public RecursoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecursoTO(Integer id, String nombre, String apellido, Boolean dinamico, PerfilTO perfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dinamico = dinamico;
		this.perfil = perfil;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getDinamico() {
		return dinamico;
	}

	public void setDinamico(Boolean dinamico) {
		this.dinamico = dinamico;
	}

	public PerfilTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilTO perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "RecursoTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dinamico=" + dinamico
				+ ", perfil=" + perfil + "]";
	}
}
