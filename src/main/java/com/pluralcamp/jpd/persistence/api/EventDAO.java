package com.pluralcamp.jpd.persistence.api;

import java.util.List;

import com.pluralcamp.jpd.entities.Event;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;

public interface EventDAO {
    Event getEventById(long id) throws DAOException;
    List<Event> getEvents() throws DAOException;
    List<Event> getEvents(int offset, int count) throws DAOException;
    List<Event> getEvents(String searchTerm) throws DAOException;
    List<Event> getEvents(String searchTerm, int offset, int count) throws DAOException;
   
    long getNumOfEvents() throws DAOException;
}
