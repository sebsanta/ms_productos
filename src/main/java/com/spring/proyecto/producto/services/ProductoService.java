package com.spring.proyecto.producto.services;

import java.util.List;
import java.util.Optional;

import com.spring.proyecto.producto.models.entities.Producto;

public interface ProductoService {
	
	//listar todos los productos
	List<Producto> findAll();
	
	//buscar por id
	Optional<Producto> findById(Long id);
	
	//guardar un producto
	Producto save(Producto producto);
	
	//eliminar producto
	void remove(Long id);
	
	

}
