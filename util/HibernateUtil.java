package com.yash.app.util;
import java.util.Properties;

import java.util.Properties;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;
import org.hibernate.service.ServiceRegistry;

import com.yash.app.entity.Album;
import com.yash.app.entity.Song;



public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");//MySQL5InnoDBDialect

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				//<property name="hibernate.enable_lazy_load_no_trans">true</property>
				settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				//settings.put(Environment.AUTOCOMMIT, "false");
				//hibernate.connection.autocommit
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Song.class).addAnnotatedClass(Album.class);
				//configuration.addAnnotatedClass(Album.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch(HibernateException exception){
			     System.out.println("Problem creating session factory");
			     exception.printStackTrace();
			}
		}
		return sessionFactory;
	}
}