package com.uday.springcloud.random;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;



public class CustomRandomIdGenerator implements IdentifierGenerator {


	private static final long serialVersionUID = 1L;

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		
		Random random = null;
		int id = 0;
		
		random = new Random();
		id = random.nextInt(1000);
		
		return new Long(id);
	}


	

}
