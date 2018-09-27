package com.massglobal.emplmanagement.service.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.massglobal.emplmanagement.emplfactory.EmployeeFactory;
import com.massglobal.emplmanagement.rest.EmployeeResource;
import com.massglobal.emplmanagement.service.EmployeeService;
import com.massglobal.emplmanagement.service.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static final String EMPLOYEE_URL = "http://masglobaltestapi.azurewebsites.net/api/employees";
	private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

	public ArrayList<EmployeeDTO> getEmployeesObj() {

		log.debug("Getting all employees from rest and Assigning them to the correct dto");

		RestTemplate restTemplate = new RestTemplate();
		EmployeeFactory employeeFactory = new EmployeeFactory();
		ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;

		ResponseEntity<String> response = restTemplate.getForEntity(EMPLOYEE_URL, String.class);

		try {
			root = mapper.readTree(response.getBody());

			root.forEach(t -> {

				try {
					EmployeeDTO empl = mapper.treeToValue(t,
							employeeFactory.createEmployee(t.path("contractTypeName").textValue()).getClass());
					empl.setAnnualSalary();

					employees.add(empl);

				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception e) {
		}

		return employees;
	}

	@Override
	public ArrayList<EmployeeDTO> getEmployees() {

		log.debug("Getting all employees from rest");

		return getEmployeesObj();
	}

	@Override
	public EmployeeDTO findEmploye(Long id) {

		log.debug("Getting employee with id {}", id);

		ArrayList<EmployeeDTO> employees = getEmployeesObj();

		Optional<EmployeeDTO> optionalEmployee = employees.stream().filter(e -> e.getId() == id).findFirst();

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else {
			return null;
		}

	}

}
