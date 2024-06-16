package dataaccess.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/book_manage";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void setStatementParameter(PreparedStatement preparedStatement, List<Object> paramValue) throws SQLException {
        for (int i = 0; i < paramValue.size(); i++) {
            Object param = paramValue.get(i);
            if (param instanceof Integer) {
                preparedStatement.setInt(i + 1, (Integer) param);
            } else if (param instanceof String) {
                preparedStatement.setString(i + 1, (String) param);
            } else if (param instanceof Timestamp) {
                preparedStatement.setTimestamp(i + 1, (Timestamp) param);
            } else if (param instanceof Boolean) {
                preparedStatement.setBoolean(i + 1, (Boolean) param);
            } else if (param instanceof Double) {
                preparedStatement.setDouble(i + 1, (Double) param);
            } else if (param instanceof Float) {
                preparedStatement.setFloat(i + 1, (Float) param);
            } else if (param instanceof Long) {
                preparedStatement.setLong(i + 1, (Long) param);
            } else if (param instanceof Byte) {
                preparedStatement.setByte(i + 1, (Byte) param);
            } else if (param instanceof Short) {
                preparedStatement.setShort(i + 1, (Short) param);
            } else {
                throw new SQLException("Unsupported parameter type: " + param.getClass().getName());
            }
        }
    }
}
