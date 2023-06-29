package com.spring.proyecto.producto.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.proyecto.producto.models.entities.Producto;
import com.spring.proyecto.producto.services.ProductoService;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public List<Producto> list(){
		return service.findAll();
	}
	
	//<>
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Optional<Producto> productoOptional = service.findById(id);
		if(productoOptional.isPresent()) {
			return ResponseEntity.ok(productoOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result){
		if(result.hasErrors()) {
			return validation(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return validation(result);
		}
		Optional<Producto> o = service.findById(id);
		if(o.isPresent()) {
			Producto productoDB = o.orElseThrow();
			productoDB.setCodigo(producto.getCodigo());
			productoDB.setDescripcion(producto.getDescripcion());
			productoDB.setFormalizado(producto.getFormalizado());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id){
		Optional<Producto> o = service.findById(id);
		if(o.isPresent()) {
			service.remove(id);
			return ResponseEntity.noContent().build(); //204 no tiene contenido
		}
		return ResponseEntity.notFound().build();
	}
	
	//Método personalizado para respuestas de error o validation
	private ResponseEntity<?> validation(BindingResult result) {
		Map<String, String> errors = new HashMap<>();
		result.getFieldErrors().forEach(err-> {
			errors.put(err.getField(), "El campo "+err.getField()+" "+ err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errors);
	}
	
	
	
	
}
