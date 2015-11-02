package de.todd.userdb.services;

import java.util.List;

public interface AbstractService<T> {

	List<T> getAllEntities();

	void addEntity(T entity);

	void deleteEntity(T entity);

	void updateEntity(T entity);
}
