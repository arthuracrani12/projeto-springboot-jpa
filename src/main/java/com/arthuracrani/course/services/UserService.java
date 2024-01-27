package com.arthuracrani.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthuracrani.course.entities.User;
import com.arthuracrani.course.repositories.UserRepository;

//Registrar  classe no mecanismo de gestão de depêndencia para ser a clsse user service é preciso registrara como componente
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//metodo para retornar todos usuraios do BD
	public List<User> findAll() {
		return repository.findAll();		
	
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
