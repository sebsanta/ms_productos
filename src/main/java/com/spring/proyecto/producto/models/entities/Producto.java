package com.spring.proyecto.producto.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(unique= true)
	private String codigo;
	private String descripcion;
	private Boolean formalizado;
	
	public Producto(Long id, String codigo, String descripcion, Boolean formalizado) {
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.formalizado = formalizado;
	}

	public Producto() {	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getFormalizado() {
		return formalizado;
	}

	public void setFormalizado(Boolean formalizado) {
		this.formalizado = formalizado;
	}

	private static final long serialVersionUID = 2378147467460968821L;
	
	
	
	
	
}
