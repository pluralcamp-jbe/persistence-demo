package com.pluralcamp.jpd.ui;

import com.pluralcamp.jpd.persistence.api.ColorDAO;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;
import com.pluralcamp.jpd.persistence.providers.jdbc.ColorDAOJDBCImpl;

public class App {

	public static void main(String[] args) {
		ColorDAO colorDAO = new ColorDAOJDBCImpl();
	    try {
            var c = colorDAO.getColorById(5);
            if (c != null) {
                System.out.println(c.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }

	}

}
