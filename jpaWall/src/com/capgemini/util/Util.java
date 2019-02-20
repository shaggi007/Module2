package com.capgemini.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {


	private static EntityManagerFactory factory;
	
	public Util() {
		
		factory = Persistence.createEntityManagerFactory("Wallet-Service");
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
}
