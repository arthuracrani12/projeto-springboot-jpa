package com.arthuracrani.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthuracrani.course.entities.Category;
import com.arthuracrani.course.repositories.CategoryRepository;

//Registrar  classe no mecanismo de gestão de depêndencia para ser a clsse user service é preciso registrara como componente
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//metodo para retornar todos usuraios do BD
	public List<Category> findAll() {
		return repository.findAll();		
	
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
