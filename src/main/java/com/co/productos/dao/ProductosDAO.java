package com.co.productos.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.co.productos.objeto.Productos;


public interface ProductosDAO extends JpaRepository<Productos, Long> {
	
	@Query(value = "SELECT * FROM experimentality.productos ORDER BY buscados DESC LIMIT 4", nativeQuery = true) 
    List<Productos> buscados();
	
	@Query(value = "SELECT * FROM experimentality.productos where producto like %:nombre%", nativeQuery = true)
    List<Productos> nombre(String nombre);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE experimentality.productos SET buscados = :buscado WHERE id = :id", nativeQuery = true)
	void actualiza(Long id, int buscado);
	
	@Query(value = "SELECT * FROM experimentality.productos where id = :id", nativeQuery = true) 
    List<Productos> id(String id);
	
	@Query(value = "SELECT * FROM experimentality.productos WHERE CARRITO = 1 ORDER BY carrito DESC", nativeQuery = true) 
    List<Productos> carrito();

}
