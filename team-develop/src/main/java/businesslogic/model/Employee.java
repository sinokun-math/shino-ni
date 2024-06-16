package businesslogic.model;

import java.sql.Timestamp;

public class Employee {
	private final int idEmployee;
	private final String nmEmployee;
	private final String knEmployee;
	private final String mailAddress;
	private final String password;
	private final char flgAdmin;
	private final char flgRetirement;
	private final int idUpdate;
	private final Timestamp dateUpdate;

	public Employee(int idEmployee, String nmEmployee, String knEmployee, String mailAddress, String password,
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

	// Getters
	public int getIdEmployee() {
		return idEmployee;
	}

	public String getNmEmployee() {
		return nmEmployee;
	}

	public String getKnEmployee() {
		return knEmployee;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public char getFlgAdmin() {
		return flgAdmin;
	}

	public char getFlgRetirement() {
		return flgRetirement;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public Timestamp getDateUpdate() {
		return dateUpdate;
	}

}
