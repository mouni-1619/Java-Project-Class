package org.jsp.MerchantProductApp.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.MerchantProductApp.dto.Merchant;

public class MerchantDao {
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
	public	Merchant saveMerchant(Merchant m){
		//to avoid boiler plate code we write in side entity 

			EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(m);
			et.commit();
			return m;
	}
	public Merchant updateMerchant(Merchant m) {
		EntityTransaction et1=em.getTransaction();
		et1.begin();
		Merchant m1=em.find(Merchant.class, m.getId());
		if(m1!=null) {
			m1.setName(m.getName());
			m1.setEmail(m.getEmail());
			et1.commit();
			return m1;
		}else {
			System.out.println("No Data to update");
			return null;
		}
		
	}
	public Merchant findMerchantById(int id) {
		Merchant m1=em.find(Merchant.class,id);
		return m1;
	}
	public Merchant VerfiyMerchantEmailAndPassword(String email, String pass) {
		 try {
	            // JPQL Query
	            String jpql = "SELECT m FROM Merchant m WHERE m.email = :email AND m.password = :password";
	            Query query = em.createQuery(jpql);
	            query.setParameter("email", email);
	            query.setParameter("password", pass);
	            return (Merchant) query.getSingleResult();
	        } catch (NoResultException e) {
	          
	            return null;
	        }
	}
	public Merchant verifyByPhoneNumAndPassword(long mn, String pass) {
		try {
			Query q=em.createQuery("select m from Merchant m where m.mono=?1 and m.password=?2");
			q.setParameter(1, mn);
			q.setParameter(2, pass);
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
		
	}


