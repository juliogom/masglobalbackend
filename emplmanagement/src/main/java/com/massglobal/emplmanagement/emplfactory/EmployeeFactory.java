package com.massglobal.emplmanagement.emplfactory;


import com.massglobal.emplmanagement.service.dto.EmployeeDTO;
import com.massglobal.emplmanagement.service.dto.HourlySalaryEmployeeDTO;
import com.massglobal.emplmanagement.service.dto.MonthlySalaryEmployeeDTO;

public class EmployeeFactory {

	private EmployeeDTO employee;

	public EmployeeDTO createEmployee(String contractType) {

		switch (contractType) {

		case "HourlySalaryEmployee":
			this.employee = new HourlySalaryEmployeeDTO() ;
			break;

		case "MonthlySalaryEmployee":
			this.employee = new MonthlySalaryEmployeeDTO();
			break;
		}
		
		return employee;

	}

}
