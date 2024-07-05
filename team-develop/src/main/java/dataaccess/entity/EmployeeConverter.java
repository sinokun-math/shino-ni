package dataaccess.entity;

import businesslogic.model.Employee;
import dataaccess.entity.status.RetiredStatus;
import dataaccess.entity.status.UserStatus;

public class EmployeeConverter {

	// Convert from Employee model
	public static EmployeeEntity convertToEntity(Employee model) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setIdEmployee(model.getIdEmployee());
		entity.setNmEmployee(model.getNmEmployee());
		entity.setKnEmployee(model.getKnEmployee());
		entity.setMailAddress(model.getMailAddress());
		entity.setPassword(model.getPassword());
		entity.setFlgAdmin(UserStatus.fromModelValue(model.getIsAdmin()));
		entity.setFlgRetirement(RetiredStatus.fromModelValue(model.getIsRetired()));
		entity.setIdUpdate(model.getIdUpdate());
		entity.setDateUpdate(model.getDateUpdate());
		return entity;
	}

	public static Employee convertToModel(EmployeeEntity entity) {
		return new Employee.Builder(
				entity.getIdEmployee(), 
				entity.getNmEmployee(),
				entity.getKnEmployee(),
				entity.getMailAddress(),
				entity.getPassword(),
				UserStatus.fromDbValue(entity.getFlgAdmin()),
				UserStatus.fromDbValue(entity.getFlgRetirement()),
				entity.getIdUpdate(),
				entity.getDateUpdate())
				.build(); 
	}
}