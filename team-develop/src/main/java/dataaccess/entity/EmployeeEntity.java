package dataaccess.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EmployeeEntity {
	private int idEmployee;
	private String nmEmployee;
	private String knEmployee;
	private String mailAddress;
	private String password;
	private char flgAdmin;
	private char flgRetirement;
	private int idUpdate;
	private Timestamp dateUpdate;

	// Getters and setters
	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNmEmployee() {
		return nmEmployee;
	}

	public void setNmEmployee(String nmEmployee) {
		this.nmEmployee = nmEmployee;
	}

	public String getKnEmployee() {
		return knEmployee;
	}

	public void setKnEmployee(String knEmployee) {
		this.knEmployee = knEmployee;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getFlgAdmin() {
		return flgAdmin;
	}

	public void setFlgAdmin(char flgAdmin) {
		this.flgAdmin = flgAdmin;
	}

	public char getFlgRetirement() {
		return flgRetirement;
	}

	public void setFlgRetirement(char flgRetirement) {
		this.flgRetirement = flgRetirement;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(int idUpdate) {
		this.idUpdate = idUpdate;
	}

	public Timestamp getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	// Convert from ResultSet
	public static EmployeeEntity convertFrom(ResultSet resultSet) throws SQLException {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setIdEmployee(resultSet.getInt("id_employee"));
		entity.setNmEmployee(resultSet.getString("nm_employee"));
		entity.setKnEmployee(resultSet.getString("kn_employee"));
		entity.setMailAddress(resultSet.getString("mail_address"));
		entity.setPassword(resultSet.getString("password"));
		entity.setFlgAdmin(resultSet.getString("flg_admin").charAt(0));
		entity.setFlgRetirement(resultSet.getString("flg_retirement").charAt(0));
		entity.setIdUpdate(resultSet.getInt("id_update"));
		entity.setDateUpdate(resultSet.getTimestamp("date_update"));
		return entity;
	}
	
	// Constructor for EmployeeEntity
	public EmployeeEntity(int idEmployee, String nmEmployee, String knEmployee, String mailAddress, String password,
			char flgAdmin, char flgRetirement, int idUpdate, Timestamp dateUpdate) {
		this.idEmployee = idEmployee;
		this.nmEmployee = nmEmployee;
		this.knEmployee = knEmployee;
		this.mailAddress = mailAddress;
		this.password = password;
		this.flgAdmin = flgAdmin;
		this.flgRetirement = flgRetirement;
		this.idUpdate = idUpdate;
		this.dateUpdate = dateUpdate;
	}

	// Default constructor
	public EmployeeEntity() {
	}

	

}
