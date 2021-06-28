package com.co.productos.objeto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incremente automaticamente
	private Long id;

	@Column(name = "producto")
	private String producto;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private Integer precio;

	@Column(name = "preciodto")
	private Integer preciodto;

	@Column(name = "dto")
	private Integer dto;

	@Column(name = "imagenf")
	private String imagenf;

	@Column(name = "imagent")
	private String imagent;

	@Column(name = "buscados")
	private Integer buscados;

	@Column(name = "carrito")
	private Integer carrito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPreciodto() {
		return preciodto;
	}

	public void setPreciodto(Integer preciodto) {
		this.preciodto = preciodto;
	}

	public Integer getDto() {
		return dto;
	}

	public void setDto(Integer dto) {
		this.dto = dto;
	}

	public String getImagenf() {
		return imagenf;
	}

	public void setImagenf(String imagenf) {
		this.imagenf = imagenf;
	}

	public String getImagent() {
		return imagent;
	}

	public void setImagent(String imagent) {
		this.imagent = imagent;
	}

	public Integer getBuscados() {
		return buscados;
	}

	public void setBuscados(Integer buscados) {
		this.buscados = buscados;
	}

	public Integer getCarrito() {
		return carrito;
	}

	public void setCarrito(Integer carrito) {
		this.carrito = carrito;
	}

}
