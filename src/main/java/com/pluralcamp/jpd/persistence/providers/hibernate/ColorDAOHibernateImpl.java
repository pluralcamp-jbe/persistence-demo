package com.pluralcamp.jpd.persistence.providers.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pluralcamp.jpd.entities.Color;
import com.pluralcamp.jpd.persistence.api.ColorDAO;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;
import com.pluralcamp.jpd.persistence.providers.hibernate.utils.HibernateUtils;

public class ColorDAOHibernateImpl implements ColorDAO {

	@Override
	public Color getColorById(long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Color> getColors() throws DAOException {
		List<Color> colors = null;
		
		//try-with-resources
		try(
				Session session = HibernateUtils.getSessionFactory().openSession();				
			){
			@SuppressWarnings("deprecation")
			var<Color> hql = session.createQuery("FROM Color");
			colors = hql.list();
			
		} catch(HibernateException ex) {
			throw new DAOException(ex);
		}
		return colors;
	}

	@Override
	public List<Color> getColors(int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfColors() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
