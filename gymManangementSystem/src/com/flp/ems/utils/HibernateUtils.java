package com.flp.ems.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	static SessionFactory sf;
	static
	{
	Configuration cfg=new Configuration().configure();
	ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	sf=cfg.buildSessionFactory(sr);
	}
	public static SessionFactory getSf() {
		return sf;
	}
	
	public static Session getSession()
	{
		return sf.openSession();
	}
	
}
