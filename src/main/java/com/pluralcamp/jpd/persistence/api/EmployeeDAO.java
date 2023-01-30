package com.pluralcamp.jpd.persistence.api;

import java.util.List;

import com.pluralcamp.jpd.entities.Employee;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;

public interface EmployeeDAO {
    Employee getEmployeeById(long id) throws DAOException;
    List<Employee> getEmployees() throws DAOException;
    List<Employee> getEmployees(int offset, int count) throws DAOException;
    List<Employee> getEmployees(String searchTerm) throws DAOException;
    List<Employee> getEmployees(String searchTerm, int offset, int count) throws DAOException;
    
    long getNumOfEmployees() throws DAOException;
    
    public Employee addEmployee(Employee employee) throws DAOException;
}
