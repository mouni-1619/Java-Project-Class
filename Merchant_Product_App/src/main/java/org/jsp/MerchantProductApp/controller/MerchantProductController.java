package org.jsp.MerchantProductApp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.MerchantProductApp.dao.MerchantDao;
import org.jsp.MerchantProductApp.dao.ProductDao;
import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class MerchantProductController {
	static Scanner scn=new Scanner(System.in);
	static MerchantDao md=new MerchantDao();
	static ProductDao pd=new ProductDao();
	public static void main(String[] args) {
		System.out.println("1.Save Merchant ");
		System.out.println("2.Update Merchant ");
		System.out.println("3.Find Merchant by id");
		System.out.println("4.Verify Merchant by email and password ");
		System.out.println("5.Verify Merchant  by Phone and password");
		System.out.println("6.Add Product ");
		System.out.println("7.Update product ");
		System.out.println("7.Find product by Merchant id ");
		System.out.println("9.Find product by brand ");
		System.out.println("10.Find product by category");
		System.out.println("Enter Your Choise??");
		int choise=scn.nextInt();
		switch (choise) {
		case 1:
			saveMerchant();
			break;
		case 2:
			updateMerchant();
			break;
		case 3:
			findMerchantById();
			break;
		case 4:
			verifyMerchantByEmailandPassword();
			break;
		case 5:
			verifyMerchantByPhoneAndPassWord();
			break;
		case 6:
			addProduct();
			break;
		case 7:
			updateProduct();
			break;
		case 8:
			findProductbyMerchantId();
			break;
		case 9:
			findProductByBrand();
			break;
		case 10:
			findProductBycategory();
			break;
		default:
			break;
		}
	}
	
	private static void saveMerchant() {
		System.out.println("Emter Merchant you want to save name,mono,gstnum,email,password");
		String name=scn.next();
		long mono=scn.nextLong();
		String gstno=scn.next();
		String email=scn.next();
		String password=scn.next();
		Merchant m=new Merchant();
		m.setName(name);
		m.setMono(mono);
		m.setGdtno(gstno);
		m.setEmail(email);
		m.setPassword(password);
		Merchant m1=md.saveMerchant(m);
		System.out.println(m1);
	}
	private static void updateMerchant() {
		System.out.println("Enter the valuse you want to update id,name,email");
		int id=scn.nextInt();
		String name=scn.next();
		String email=scn.next();
		Merchant m=new Merchant();
		m.setId(id);
		m.setName(name);
		m.setEmail(email);
		Merchant m1=md.updateMerchant(m);
		if(m1!=null) {
			System.out.println("Merchant informations are updated!!");
		}else {
			System.err.println("No Merchant is updated becose id is invalid");
		}
		
	}
	private static void findMerchantById() {
		System.out.println("Enter the id you whant to find the Merchant");
		int id=scn.nextInt();
		Merchant m=md.findMerchantById(id);
		System.out.println(m);
	}
	private static void verifyMerchantByEmailandPassword() {
		System.out.println("Enter the email and password to find the merchant");
		String email=scn.next();
		String pass=scn.next();
		Merchant m=md.VerfiyMerchantEmailAndPassword(email,pass);
		if(m!=null) {
			System.out.println("Merchant informations is Verifed by this email "+email+" Passwoed "+pass);
		}else {
			System.err.println("No Merchant is Verifed in email and password are invalid");
		}
		
	}
	private static void verifyMerchantByPhoneAndPassWord() {
	System.out.println("Enter the Mobile number And Password");
	long mn=scn.nextLong();
	String pass=scn.next();
	Merchant m=md.verifyByPhoneNumAndPassword(mn,pass);
	if(m!=null) {
		System.out.println("Merchant informations is Verifed by this Mobile number "+mn+" Passwoed "+pass);
	}else {
		System.err.println("No Merchant is Verifed in  Mobile number and password are invalid");
	}
		
	}
	private static void addProduct() {
		System.out.println("Enter the merchant id to add the produvt to merchabt");
		int mid=scn.nextInt();
		System.out.println("Enter the Product Details name,brand,categary and Discription");
		String name=scn.next();
		String brand=scn.next();
		String categ=scn.next();
		String discript=scn.next();
		Product p=new Product();
		p.setName(name);
		p.setBrand(brand);
		p.setCategary(categ);
		p.setDescription(discript);
		Product p1=pd.addProduct(p,mid);
		if(p1!=null) {
			System.out.println("Produvte is added to merchant id of this "+mid);
			System.out.println(p1);
		}else {
			System.err.println("merchant is not prest so product is not added");
		}
	}
	private static void updateProduct() {
System.out.println("Enter the Product id to update");
int id=scn.nextInt();
System.out.println("Enter the updating discriptio of the product");
String dis=scn.next();
Product p1=new Product();
p1.setDescription(dis);
Product p=pd.updateProduct(id,p1);
if(p!=null) {
	System.out.println(" product is updated");
	System.out.println(p);
}else {
	System.err.println("No product is updated becose id is invalid");
}
	}
	private static void findProductbyMerchantId() {
		System.out.println("Enter The Merchant id to fech the list of Products");
		int id=scn.nextInt();
		List<Product> l=pd.findProductByMerchantId(id);
		if(l!=null) {
			System.out.println("Product are Find By this id "+id);
			for(Product p:l) {
			System.out.println(p);
			}
		}else {
			System.err.println("No Data is Present in this Merchant id is invalid");
		}
		
	}
	private static void findProductByBrand() {
		System.out.println("Enter the Product of brand to feach");
		String brand=scn.next();
		Product p=pd.findProductByBrand(brand);
		if(p!=null) {
			System.out.println(" product is Find by this Brand");
			System.out.println(p);
		}else {
			System.err.println("No product is found Brand is invalid");
		}
	}
	private static void findProductBycategory() {
		System.out.println("Enter the categary of the product you want to feach");
		String categary=scn.next();
		Product p=pd.findProductByCategary(categary);
		if(p!=null) {
			System.out.println(" product is Find by this categary");
			System.out.println(p);
		}else {
			System.err.println("No product is found categary is invalid");
		}
	}
}
