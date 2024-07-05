package dataaccess.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T, ID> {
	void save(T entity) throws SQLException;
	void update(T entity) throws SQLException;
	void delete(T entity) throws SQLException;
	T findById(ID id) throws SQLException;
	List<T> findAll() throws SQLException;
}