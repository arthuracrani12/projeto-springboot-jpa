package com.arthuracrani.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthuracrani.course.entities.Order;
import com.arthuracrani.course.repositories.OrderRepository;

//Registrar  classe no mecanismo de gestão de depêndencia para ser a clsse user service é preciso registrara como componente
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//metodo para retornar todos usuraios do BD
	public List<Order> findAll() {
		return repository.findAll();		
	
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
