package com.tsoft.assignment.dao;

import java.util.List;

import javax.persistence.Query;

public interface GenericoDAO {

	public Object guardarOActualizar(Object object);
	
	public List<Object> buscar(String query);
	
	public Query getQuery(String query);

}
