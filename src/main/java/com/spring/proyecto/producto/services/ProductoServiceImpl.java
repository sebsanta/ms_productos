package com.spring.proyecto.producto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.proyecto.producto.models.entities.Producto;
import com.spring.proyecto.producto.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return repository.save(producto);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
