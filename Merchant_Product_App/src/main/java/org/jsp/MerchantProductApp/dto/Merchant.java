package org.jsp.MerchantProductApp.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mono;
	private String gdtno;
	private String email;
	private String password;
	@OneToMany(mappedBy = "merchant")
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMono() {
		return mono;
	}
	public void setMono(long mono) {
		this.mono = mono;
	}
	public String getGdtno() {
		return gdtno;
	}
	public void setGdtno(String gdtno) {
		this.gdtno = gdtno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", mono=" + mono + ", gdtno=" + gdtno + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
