package dataaccess.dao;

import java.sql.Connection;
import java.sql.SQLException;

import dataaccess.dao.util.DatabaseConnection;

public class QueryExecutor {
	private final DatabaseConnection dataSource;
	
	public QueryExecutor(DatabaseConnection dataSource) {
		this.dataSource = dataSource;
	}
	
	public <R> R executeQuery(QueryFunction<Connection, R> queryFunction) {
		try (Connection connection = dataSource.getConnection()) {
			return queryFunction.appry(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
