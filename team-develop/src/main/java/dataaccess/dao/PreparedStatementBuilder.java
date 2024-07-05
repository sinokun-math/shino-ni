package dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBuilder {
	private Connection connection;
	private String sql;
	private ParameterMapper parameterMapper;
	public PreparedStatementBuilder(Connection connection, String sql) {
		this.connection = connection;
		this.sql = sql;
		this.parameterMapper = new ParameterMapper();
	}
	
	public PreparedStatementBuilder setParameter(int index, Object value) {
		parameterMapper.addParameter(index, value);
		return this;
	}
	
	public PreparedStatement builder() throws SQLException {
		return StatementPreparer.prepareStatement(connection, sql, parameterMapper);
	}
	
	
}
