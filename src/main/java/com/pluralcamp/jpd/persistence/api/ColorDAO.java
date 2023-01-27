package com.pluralcamp.jpd.persistence.api;

import java.util.List;

import com.pluralcamp.jpd.entities.Color;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;

public interface ColorDAO {
	public Color getColorById(long id) throws DAOException; 
	public List<Color> getColors() throws DAOException;
	public List<Color> getColors(int offset, int count) throws DAOException;
	public List<Color> getColors(String searchTerm) throws DAOException;
	public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException;
	
	public long getNumOfColors() throws DAOException;
}
