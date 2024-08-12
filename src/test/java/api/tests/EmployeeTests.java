package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EmployeeEndPoints;
import api.payloads.Employee;
import io.restassured.response.Response;

public class EmployeeTests {
	
	Faker faker;
	Employee employeePayload;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		employeePayload=new Employee();
		
		employeePayload.setEmp_id(faker.numerify("######"));
		employeePayload.setEmp_name(faker.name().name());
		employeePayload.setDesignation("QA Engineer");
		employeePayload.setCompany(faker.company().name());
		
		String[] skills = {"Manual testing", "Selenium java","API testing","SQL","JIRA"};
		
		employeePayload.setSkills(skills);
		
	}
	

	
	@Test(priority=1)
	
	public void testAddEmployee() {
		
		Response response = EmployeeEndPoints.postEmployee(employeePayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),201);
	}
	
	@Test(priority=2, dependsOnMethods = {"testAddEmployee"})
	
	public void testGetEmployee() {
		
		Response response = EmployeeEndPoints.getEmployee(EmployeeEndPoints.Id);
		response.then().log().all();
	}
	
	@Test(priority=3)
	public void testUpdateEmployee() {
		
		employeePayload.setEmp_name(faker.name().name());
		employeePayload.setCompany(faker.company().name());
		
		String[] skills = {"Manual testing", "Selenium java","API testing","restAssured", "SQL","JIRA","GIT"};
		employeePayload.setSkills(skills);
	
	    
	    Response response = EmployeeEndPoints.updateEmployee(EmployeeEndPoints.Id,employeePayload);
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but found " + response.getStatusCode());
	    
	    Response response_after = EmployeeEndPoints.getEmployee(EmployeeEndPoints.Id);
	    response_after.then().log().all();
	}
	
	@Test(priority=4, dependsOnMethods = {"testUpdateEmployee"})
	
	public void testDeleteEmployee() {
		
		Response response = EmployeeEndPoints.deleteEmployee(EmployeeEndPoints.Id);
		response.then().log().all();
		
	}

}
