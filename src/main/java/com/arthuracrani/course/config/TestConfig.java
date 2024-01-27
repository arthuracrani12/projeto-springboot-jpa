package com.arthuracrani.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.arthuracrani.course.entities.User;
import com.arthuracrani.course.repositories.UserRepository;

//para mostrar que é uma classe de configuração
@Configuration
//para mosntrar que é uma classe de configuração especifica para teste
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	//implementnado commandLineRunner tudo que estiver na função run será executdao quando a função for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		//ID está null pq o ID será gerado pelo BD
		User u1 = new User(null, "Arthur Acrani", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Bruno aaa", "alex@gmail.com", "977777777", "123456"); 

		//salvar os usuarios no BD
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}
