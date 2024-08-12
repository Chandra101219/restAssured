package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndpoints {
	
	public static Response addPet(Pet payload)
	{
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);
		return response;
	}

	public static Response getPet(int petid)
	{
		Response response = 
				given()
					.pathParam("petid", petid)
				.when()
					.get(Routes.get_url);
		return response;
	}

	public static Response updatePet(Pet payload)
	{
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.pathParam("petid", petid)
					.body(payload)
				.when()
					.put(Routes.update_url);
		return response;
	}

	public static Response deletePet(int petid)
	{
		Response response = 
				given()
					.pathParam("petid", petid)
				.when()
					.delete(Routes.delete_url);
		return response;
	}


}
