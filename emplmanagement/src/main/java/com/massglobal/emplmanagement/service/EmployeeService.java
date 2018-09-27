package com.massglobal.emplmanagement.service;

import java.util.ArrayList;
import java.util.Optional;

import com.massglobal.emplmanagement.service.dto.EmployeeDTO;

public interface EmployeeService {

	public ArrayList<EmployeeDTO> getEmployees();
	
	public EmployeeDTO  findEmploye(Long id);
	
}
