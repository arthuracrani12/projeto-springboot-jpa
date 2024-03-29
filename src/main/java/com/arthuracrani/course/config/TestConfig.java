package com.arthuracrani.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.arthuracrani.course.entities.Category;
import com.arthuracrani.course.entities.Order;
import com.arthuracrani.course.entities.OrderItem;
import com.arthuracrani.course.entities.Payment;
import com.arthuracrani.course.entities.Product;
import com.arthuracrani.course.entities.User;
import com.arthuracrani.course.entities.enums.OrderStatus;
import com.arthuracrani.course.repositories.CategoryRepository;
import com.arthuracrani.course.repositories.OrderItemRepository;
import com.arthuracrani.course.repositories.OrderRepository;
import com.arthuracrani.course.repositories.ProductRepository;
import com.arthuracrani.course.repositories.UserRepository;

//para mostrar que é uma classe de configuração
@Configuration
//para mosntrar que é uma classe de configuração especifica para teste
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	//implementnado commandLineRunner tudo que estiver na função run será executdao quando a função for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//saalvar no BD as categorias
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		//salvar no BD os produtos
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//relacionando os produtos com as categorias, associando os objetos
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		//salvar novamente os produtos com as associações feitas a cima
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//ID está null pq o ID será gerado pelo BD
		User u1 = new User(null, "Arthur Acrani", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Bruno aaa", "alex@gmail.com", "977777777", "123456"); 

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITTING_PAYMENT, u1); 
		//salvar os usuarios no BD
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);

		orderRepository.save(o1);
		
		}

}
