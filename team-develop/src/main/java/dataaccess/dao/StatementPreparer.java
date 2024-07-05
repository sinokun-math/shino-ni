package dataaccess.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

public class StatementPreparer {
	
	public static void setStatementParameter(PreparedStatement preparedStatement, Map<Integer, Object> paramValues) throws SQLException {
		for (Map.Entry<Integer, Object> entry : paramValues.entrySet()) {
			int index = entry.getKey();
			Object param = entry.getValue();
			if (param instanceof Integer) {
                preparedStatement.setInt(index, (Integer) param);
            } else if (param instanceof String) {
                preparedStatement.setString(index, (String) param);
            } else if (param instanceof Timestamp) {
                preparedStatement.setTimestamp(index, (Timestamp) param);
            } else if (param instanceof Date) {
            	preparedStatement.setDate(index, (Date) param);
            } else if (param instanceof Boolean) {
                preparedStatement.setBoolean(index, (Boolean) param);
            } else if (param instanceof Double) {
                preparedStatement.setDouble(index, (Double) param);
            } else if (param instanceof Float) {
                preparedStatement.setFloat(index, (Float) param);
            } else if (param instanceof Long) {
                preparedStatement.setLong(index, (Long) param);
            } else if (param instanceof Byte) {
                preparedStatement.setByte(index, (Byte) param);
            } else if (param instanceof Short) {
                preparedStatement.setShort(index, (Short) param);
            } else {
                throw new SQLException("Unsupported parameter type: " + param.getClass().getName());
            }
		}
	}

	public static PreparedStatement prepareStatement(Connection connection, String sql, ParameterMapper parameterMapper) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		setStatementParameter(preparedStatement, parameterMapper.getParameters());
		
		return preparedStatement;
	}
}