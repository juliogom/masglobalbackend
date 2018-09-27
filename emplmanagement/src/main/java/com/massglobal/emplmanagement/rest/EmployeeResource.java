package com.massglobal.emplmanagement.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.massglobal.emplmanagement.service.EmployeeService;
import com.massglobal.emplmanagement.service.dto.EmployeeDTO;


@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
public class EmployeeResource {
	
	private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);
	
	private final EmployeeService employeeService;
	
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	/**
     * GET /employees : get all employees.
     *
     * @author juliogomez
     * @return the ArrayList with all employees
     */
	@GetMapping("/employees")
	public ArrayList<EmployeeDTO> getAll() {
		log.debug("Getting all employees");
		return employeeService.getEmployees();

	}
	
	/**
     * GET /employees : get all employees.
     *
     * @author juliogomez
     * @param id the employee to retrieve
     * @return the Employee with an specific id
     */
	@GetMapping("/employees/{id}")
	public EmployeeDTO  findEmployee(@PathVariable Long id) {
		log.debug("Getting employee");
		return employeeService.findEmploye(id);
	}
	
}
