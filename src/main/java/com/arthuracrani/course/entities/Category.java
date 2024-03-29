package com.arthuracrani.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//mapeamentos JPA
@Entity
@Table(name = "tb_category")
//seriazible para transformar o objeto em cadeias de bites para trafegar na rede
public class Category implements Serializable {

	// número de série padrão
	private static final long serialVersionUID = 1L;

	// mostrar para o JPA qual a chave primaria do BD
	@Id
	// para a chave ser autoincrementada no BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	//para evitar loop infinito de categoria buscando produto e produto buscando categoria
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	public Category() {

	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	
}
