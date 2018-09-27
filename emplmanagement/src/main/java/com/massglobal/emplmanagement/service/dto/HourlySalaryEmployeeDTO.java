package com.massglobal.emplmanagement.service.dto;

public class HourlySalaryEmployeeDTO extends EmployeeDTO {

	public HourlySalaryEmployeeDTO() {
		
	}
	
	public HourlySalaryEmployeeDTO(Long id,String name,String contractTypeName,Long roleId,String roleName,String roleDescription,
			double hourlySalary,double monthlySalary,double annualSalary) {
		this.setId(id);
		this.setName(name);
		this.setContractTypeName(contractTypeName);
		this.setRoleId(roleId);
		this.setRoleName(roleName);
		this.setRoleDescription(roleDescription);
		this.setHourlySalary(hourlySalary);
		this.setMonthlySalary(monthlySalary);
		setAnnualSalary();
	}
	
	@Override
	public double setAnnualSalary() {
		super.annualSalary= 120 * super.getHourlySalary() * 12 ;
		return this.annualSalary;
	}

}
