package com.spring.proyecto.producto.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.proyecto.producto.models.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
