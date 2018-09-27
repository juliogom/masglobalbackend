package com.massglobal.emplmanagement.testDataBuilder;

import com.massglobal.emplmanagement.service.dto.EmployeeDTO;
import com.massglobal.emplmanagement.service.dto.HourlySalaryEmployeeDTO;
import com.massglobal.emplmanagement.service.dto.MonthlySalaryEmployeeDTO;

public class EmployeeTestDataBuilder {

	private Long id;
	private String name;
	private String contractTypeName;
	private Long roleId;
	private String roleName;
	private String roleDescription;
	private double hourlySalary;
	private double monthlySalary;
	private double annualSalary;
	
	private boolean isHourlyEmployee; 

	public EmployeeTestDataBuilder() {
			super();
			this.id=1L;
			this.name="Juan";
			this.contractTypeName="HourlySalaryEmployee";
			this.roleId=1L;
			this.roleName="Administrator";
			this.roleDescription=null;
			this.hourlySalary=60000;
			this.monthlySalary=80000;
			this.annualSalary=86400000;
			this.isHourlyEmployee=true;
		}

	public EmployeeTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public EmployeeTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public EmployeeTestDataBuilder withContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
		return this;
	}
	
	public EmployeeTestDataBuilder withRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}
	public EmployeeTestDataBuilder withRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	public EmployeeTestDataBuilder withRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
		return this;
	}
	public EmployeeTestDataBuilder withHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
		return this;
	}
	public EmployeeTestDataBuilder withName(double monthlySalary) {
		this.monthlySalary = monthlySalary;
		return this;
	}
	public EmployeeTestDataBuilder withAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
		return this;
	}
	
	public EmployeeTestDataBuilder withMonthlySalary(boolean isMonthlySalary) {
		
		if(isMonthlySalary) {
			this.id=2L;
			this.contractTypeName="MonthlySalaryEmployee";
			this.annualSalary=this.monthlySalary*12;
			this.isHourlyEmployee=false;
			this.roleId=2L;
			return this;
		}else {
			return new EmployeeTestDataBuilder();
		}
		
	}

	public EmployeeDTO build() {
		
		if(this.isHourlyEmployee) {
			return new HourlySalaryEmployeeDTO(this.id,this.name,this.contractTypeName,this.roleId,this.roleName,this.roleDescription,
					this.hourlySalary,this.monthlySalary,this.annualSalary);
		}else {
			return new MonthlySalaryEmployeeDTO(this.id,this.name,this.contractTypeName,this.roleId,this.roleName,this.roleDescription,
					this.hourlySalary,this.monthlySalary,this.annualSalary);
		}
		
	}

}
