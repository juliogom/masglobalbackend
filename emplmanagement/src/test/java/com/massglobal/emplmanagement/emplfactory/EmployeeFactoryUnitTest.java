package com.massglobal.emplmanagement.emplfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.massglobal.emplmanagement.service.dto.EmployeeDTO;
import com.massglobal.emplmanagement.testDataBuilder.EmployeeTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeFactoryUnitTest {
	
	EmployeeFactory employeeFactory;


	@Before
	public void before() {
		employeeFactory=new EmployeeFactory();
	}
	
	/**
     * Test for find a type of EmployeeDTO of a certain Employee
     *
     * @author juliogomez
     * 
     */
	@Test
	public void findEmployeTest() {
		
		EmployeeDTO emplHourlyType=new EmployeeTestDataBuilder().withMonthlySalary(false).build();
		
		assertEquals(emplHourlyType.getClass(), employeeFactory.createEmployee(emplHourlyType.getContractTypeName()).getClass());
		
	}
	
	/**
	 * Test for find a type of EmployeeDTO of a monthly paid employee
     *
     * @author juliogomez
     * 
     */
	@Test
	public void findEmployeTestMonthly() {
		
		EmployeeDTO emplHourlyType=new EmployeeTestDataBuilder().withMonthlySalary(false).build();
		
		assertEquals(new EmployeeTestDataBuilder().withMonthlySalary(false).build().getClass(), employeeFactory.createEmployee(emplHourlyType.getContractTypeName()).getClass());
		
	}
	
	
}
