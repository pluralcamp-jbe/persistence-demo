package com.pluralcamp.jpd.persistence.providers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pluralcamp.jpd.entities.Employee;
import com.pluralcamp.jpd.persistence.api.EmployeeDAO;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeById(long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() throws DAOException {
		List<Employee> empleados = new ArrayList<>();
		Employee empleado = null;
		
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";		
		
		Connection connection = null;
		PreparedStatement sentSQL = null;
		ResultSet reader = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			sentSQL = connection.prepareStatement("SELECT id, code, firstname, lastname, gender, birthdate, hireDate, monthlySalary, payments FROM employees");
			reader = sentSQL.executeQuery();
			while(reader.next()) {
				empleado = getEmployeeFrom(reader);
				empleados.add(empleado);
			}
		} catch(SQLException ex) {
			throw new DAOException(ex);
		} finally {
			try {
				reader.close();
				sentSQL.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
		return empleados;
	}
	
	//Mapeo fila - objeto
	private Employee getEmployeeFrom(ResultSet reader) throws SQLException {
	     var employee = new Employee(reader.getString("code"), 
	    		 reader.getString("firstname"), 
	    		 reader.getString("lastname"), 
	    		 Employee.Gender.valueOf(reader.getString("gender")), 
	    		 reader.getDate("birthDate").toLocalDate(), 
	    		 reader.getDate("hireDate").toLocalDate(), 
	    		 reader.getDouble("monthlySalary"), 
	    		 reader.getInt("payments"));
	        employee.setId(reader.getLong("id"));
	        return employee;
	}

	@Override
	public List<Employee> getEmployees(int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfEmployees() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee addEmployee(Employee employee) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


}
