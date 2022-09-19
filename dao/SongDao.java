package com.yash.app.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yash.app.entity.Song;
import com.yash.app.util.HibernateUtil;

@Transactional
public class SongDao {
	
		//insert or save
		public void saveSong(Song song) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
	
			session.save(song);
			// commit transaction
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
		//update
		public boolean updateSong(Song song) {
			Transaction transaction = null;
		    boolean result = false;
		    try {
		        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		        Session session = sessionFactory.getCurrentSession();
		        transaction = session.beginTransaction();
		        session.update(song);
		        transaction.commit();

		        result = true;

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        if (transaction != null) {
		            transaction.rollback();
		        }
		    }
		    return result;
		}
		
		
		
		//get song
		public Song getSongByTitle(String title) {
			Transaction transaction = null;
			Song song=null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				//transaction = session.beginTransaction();
				 song = session.load(Song.class, title);
				 
				// commit transaction
				//transaction.commit();
				
			} catch (Exception e) {
				
				 // if (transaction != null) { transaction.rollback(); }
				 
			}
			return song;
		}


		
		//retrive
		//@SuppressWarnings("unchecked")
		public List<Song> getAllSong() {
			Transaction transaction = null;
			Song song=null;
			List<Song> entityList = new ArrayList<>();
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				 song = session.load(Song.class, session);
				 CriteriaBuilder builder = session.getCriteriaBuilder();

		            // Create CriteriaQuery
		            CriteriaQuery<Song> criteria = builder.createQuery(Song.class);

		            // Specify criteria root
		            criteria.from(Song.class);

		            // Execute query
		            entityList = session.createQuery(criteria).getResultList();

				// commit transaction
				//transaction.commit();
		            
				
			} catch (Exception e) {
				
				 // if (transaction != null) { transaction.rollback(); }
				 
			}
			
			// return getCurrentSession().createCriteria(Song.class).list();
			//return getSession().createQuery("from Service").list(); 
			return entityList;
		}
		
		
		//delete
		public void delete(Song song) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
		
				session.delete(song);;
				// commit transaction
				transaction.commit();
				session.close();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}

}
