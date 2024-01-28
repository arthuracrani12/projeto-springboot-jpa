package com.arthuracrani.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthuracrani.course.entities.Product;
import com.arthuracrani.course.repositories.ProductRepository;

//Registrar  classe no mecanismo de gestão de depêndencia para ser a clsse user service é preciso registrara como componente
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//metodo para retornar todos usuraios do BD
	public List<Product> findAll() {
		return repository.findAll();		
	
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
