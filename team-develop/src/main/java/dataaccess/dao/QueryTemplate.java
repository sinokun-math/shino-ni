package dataaccess.dao;

public enum QueryTemplate {
	INSERT((String table) -> {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(table).append(" ");
	}), 
	
	UPDATE((String table) -> {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(table).append(" ");
		
	})
}
