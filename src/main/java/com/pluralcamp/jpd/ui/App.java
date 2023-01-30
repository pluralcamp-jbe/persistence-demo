package com.pluralcamp.jpd.ui;

import java.util.List;

import com.pluralcamp.jpd.entities.Color;
import com.pluralcamp.jpd.entities.Employee;
import com.pluralcamp.jpd.persistence.api.ColorDAO;
import com.pluralcamp.jpd.persistence.api.EmployeeDAO;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;
import com.pluralcamp.jpd.persistence.providers.hibernate.ColorDAOHibernateImpl;
import com.pluralcamp.jpd.persistence.providers.jdbc.EmployeeDAOJDBCImpl;

public class App {
	
	public static void main(String[] args) {
		ColorDAO colorDAO = new ColorDAOHibernateImpl();
		EmployeeDAO employeeDAO = new EmployeeDAOJDBCImpl();
	    
		//Obtener un único color por su id
//		try {
//            var c = colorDAO.getColorById(5);
//            if (c != null) {
//                System.out.println(c.toString());
//            }
//            
//        } catch (DAOException ex) {
//            System.out.printf("Error:: %s %n", ex.getMessage());
//        }
	    
		System.out.println("----- Lista de todos los colores: ------");
		
	    //Obtener la lista de todos los colores
		try {
            var colors = colorDAO.getColors();
            if (colors != null && !colors.isEmpty()) {
            	for(Color color : colors)
            		System.out.println(color.toString());
            }
            
        } catch (DAOException ex) {
            System.err.printf("Error:: %s %n", ex.getMessage());
        }				
		
		
		//Obtener la lista de todos los empleados
//		try {
//			List<Employee> empleados = employeeDAO.getEmployees();
//			if(empleados != null && !empleados.isEmpty()) {
//				for(Employee e : empleados)
//					System.out.println(e);
//			}
//		} catch(DAOException ex) {
//			System.err.printf("Error:: %s %n", ex.getMessage());
//		}
	}
}
