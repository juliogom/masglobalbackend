package com.massglobal.emplmanagement.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.massglobal.emplmanagement.service.dto.EmployeeDTO;
import com.massglobal.emplmanagement.service.serviceimpl.EmployeeServiceImpl;
import com.massglobal.emplmanagement.testDataBuilder.EmployeeTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceUnitTest {
	
	EmployeeServiceImpl employeeService;
	
	@Before
	public void before() {
		
		employeeService=Mockito.spy(new EmployeeServiceImpl());
	}
		
	/**
     * Test for find a id of EmployeeDTO of a certain Employee builded
     *
     * @author juliogomez
     * 
     */
	@Test
	public void findEmployeTest() {
		
		ArrayList<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
		
		employees.add(new EmployeeTestDataBuilder().withMonthlySalary(false).build());
		employees.add(new EmployeeTestDataBuilder().withMonthlySalary(true).build());
		
		Mockito.doReturn(employees).when(employeeService).getEmployeesObj();
		
		assertEquals(new EmployeeTestDataBuilder().withMonthlySalary(false).build().getId(), this.employeeService.findEmploye(1L).getId());
		
	}
	
	/**
     * Test for find a id of EmployeeDTO of a certain Employee builded
     *
     * @author juliogomez
     * 
     */
	@Test
	public void findEmployeTestWithDifferentId() {
		
		ArrayList<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
		
		employees.add(new EmployeeTestDataBuilder().withMonthlySalary(false).build());
		employees.add(new EmployeeTestDataBuilder().withMonthlySalary(true).build());
		
		Mockito.doReturn(employees).when(employeeService).getEmployeesObj();
		
		assertEquals(new EmployeeTestDataBuilder().withMonthlySalary(true).build().getId(), this.employeeService.findEmploye(2L).getId());
		
	}
	
}
