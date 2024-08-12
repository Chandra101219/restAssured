package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeEndPoints {
	
	public static String Id;
	
	// method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes= ResourceBundle.getBundle("routes"); // Load properties file  // name of the properties file
		return routes;
	}
	
	public static Response postEmployee(Employee payload)
	{
	
		String post_url=getURL().getString("post_url");
		
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(post_url);
		
			Id = response.jsonPath().getString("id");
		return response;
	}

	public static Response getEmployee(String id)
	{
		String get_url=getURL().getString("get_url");
		
		Response response = 
				given()
					.pathParam("id", Id)
				.when()
					.get(get_url);
		return response;
	}

	public static Response updateEmployee(String id, Employee payload)
	{
		String update_url=getURL().getString("update_url");
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("id", Id)
					.body(payload)
				.when()
					.put(update_url);
		return response;
	}

	public static Response deleteEmployee(String id)
	{
		String delete_url=getURL().getString("delete_url");
		Response response = 
				given()
					.pathParam("id", Id)
				.when()
					.delete(delete_url);
		return response;
	}

}
