package dataaccess.dao;

import java.sql.SQLException;

@FunctionalInterface
public interface QueryFunction<T, R> {
	R appry(T t) throws SQLException;
}
