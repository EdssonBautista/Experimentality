package com.co.productos.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.productos.dao.ProductosDAO;
import com.co.productos.objeto.Productos;


@RestController
@RequestMapping("prueba/api/v1")
public class ProductosREST {

	@Autowired
	private ProductosDAO productosDAO;

	// Traer todos los productos
	@RequestMapping(value = "productos")
	public ResponseEntity<List<Productos>> getProduct() {
		List<Productos> productos = productosDAO.findAll();
		return ResponseEntity.ok(productos);
	}

	// Agregar productos
	@PostMapping(value = "agregar")
	public ResponseEntity<Productos> createProduct(@RequestBody Productos productos) {
		int descuento = (productos.getPrecio() * productos.getDto()) / 100;
		productos.setProducto(productos.getProducto().toLowerCase());
		productos.setDescripcion(productos.getDescripcion().toLowerCase());
		productos.setPreciodto(productos.getPrecio() - descuento);
		Productos nuevoProducto = productosDAO.save(productos);
		return ResponseEntity.ok(nuevoProducto);
	}

	// Mas buscados
	@RequestMapping(value = "buscados", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> buscados() {
		List<Productos> productos = productosDAO.buscados();
		
		
		return ResponseEntity.ok(productos);
	}

	// Buscar producto por nombre

	@RequestMapping(value = "nombre/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> nombre(@PathVariable("nombre") String nombre) {
		List<Productos> products = productosDAO.nombre(nombre.toLowerCase());
		for (int i = 0; i < productosDAO.nombre(nombre.toLowerCase()).size(); i++) {
			productosDAO.actualiza(productosDAO.nombre(nombre.toLowerCase()).get(i).getId(),productosDAO.nombre(nombre.toLowerCase()).get(i).getBuscados()+1);
		}
		return ResponseEntity.ok(products);
	}


	// Buscar producto en especifico por ID
	@RequestMapping(value = "producto/{id}", method = RequestMethod.GET) // products/{producId}
	public ResponseEntity<List<Productos>> id(@PathVariable("id") String id) {
		List<Productos> products = productosDAO.id(id);
		return ResponseEntity.ok(products);
	}

	// Buscar en el carrito de compras
	@RequestMapping(value = "carrito", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> carrito() {
		List<Productos> productos = productosDAO.carrito();
		return ResponseEntity.ok(productos);
	}

	// Agregar al carrito
	@PutMapping(value = "carrito")
	public ResponseEntity<Productos> agregaCarrito(@RequestBody Productos producto) {
		Optional<Productos> optionalProduct = productosDAO.findById(producto.getId());
		if (optionalProduct.isPresent()) {
			Productos updateProduct = optionalProduct.get();
			updateProduct.setCarrito(1);
			productosDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
