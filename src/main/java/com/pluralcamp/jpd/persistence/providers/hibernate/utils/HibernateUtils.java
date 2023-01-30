package com.pluralcamp.jpd.persistence.providers.hibernate.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;
	
	private HibernateUtils() {}
	
	public static void initialize() {
		var resource = HibernateUtils.class.getResource("/com/pluralcamp/jpd/persistence/providers/hibernate/config/hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().
							configure(new File(resource.getPath())).build();
		sessionFactory = new MetadataSources(serviceRegistry).
							buildMetadata().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			initialize();
		return sessionFactory;
	}
	
	public static void stop() {
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
	}
	
}
