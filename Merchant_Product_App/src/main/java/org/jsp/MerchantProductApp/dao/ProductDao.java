package org.jsp.MerchantProductApp.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class ProductDao {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
EntityManager em=emf.createEntityManager();
	public Product addProduct(Product p, int mid) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Merchant m=em.find(Merchant.class, mid);
		if(m!=null) {
		m.getProducts().add(p);
		p.setMerchant(m);
		em.persist(p);
		et.commit();
		return p;
		}else {
			return null;
		}
		
	}
	public Product updateProduct(int id, Product p1) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Product p=em.find(Product.class, id);
		if(p!=null) {
			p.setDescription(p1.getDescription());
			et.commit();
			return p;
		}else {
		return null;
		}
	}
	public List<Product> findProductByMerchantId(int id) {
		Query q=em.createQuery("select m.products from Merchant m where m.id=?1");
		q.setParameter(1, id);
		List<Product> l=q.getResultList();
	if(l!=null) {
		return l;
	}else {
		return null;
	}
	}
	public Product findProductByBrand(String brand) {
		Query q=em.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		try {
			Product p=(Product) q.getSingleResult();
			return p;
		} catch (NoResultException e) {
			return null;
		}
		
	}
	public Product findProductByCategary(String categary) {
		Query q=em.createQuery("select p from Product p where p.categary=?1");
		q.setParameter(1,categary );
		try {
			Product p=(Product) q.getSingleResult();
			return p;
		} catch ( NoResultException e) {
			return null;
		}
	}

}
