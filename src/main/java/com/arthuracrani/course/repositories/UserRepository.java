package com.arthuracrani.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthuracrani.course.entities.User;

//instaancia objeto repository com várias operações paaara trabalhar com o usuario
//não é preciso implementar essa interface pq o SpringDataSTA já possui impletação padrão paraa essa interface
public interface UserRepository extends JpaRepository<User, Long>{

	
}
