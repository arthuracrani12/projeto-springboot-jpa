package com.arthuracrani.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.arthuracrani.course.entities.User;
import com.arthuracrani.course.repositories.UserRepository;
import com.arthuracrani.course.services.exceptions.DatabaseException;
import com.arthuracrani.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		//tenta dar o get, se não der retorna o erro
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
