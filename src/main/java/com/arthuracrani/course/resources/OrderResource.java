package com.arthuracrani.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthuracrani.course.entities.Order;
import com.arthuracrani.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	//para que o spring já realize a injeção de depeendcia 
	@Autowired
	private OrderService service;
	
	
	//controlador Rest que responde no caminhgo Order
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//indica que a requisição aceita um ID dentro da URL
	//endpoint da aplicação
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}


