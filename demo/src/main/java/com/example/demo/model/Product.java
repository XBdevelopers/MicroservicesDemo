package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TABLE")
public class Product {
	
	@Id
	@SequenceGenerator(name = "my_sequence", sequenceName = "PRODUCT_SEQUENCE", initialValue = 100)
	@GeneratedValue(generator = "my_sequence", strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", name=" + name + "]";
	}
	
	
}
