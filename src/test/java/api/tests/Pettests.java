package api.tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndpoints;
import api.payloads.Pet;
import api.payloads.Pet.Category;
import api.payloads.Pet.Tag;
import io.restassured.response.Response;

public class Pettests {
	
	Faker faker;
	Pet petPayload;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		petPayload=new Pet();
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setName(faker.name().name());
		
		
		//category
		Category category = new Category(101, "shihtzu");
		petPayload.setCategory(category);
		
		//tag section
		
		int petid = petPayload.getId();
		String petname = petPayload.getName();
		Tag tag = new Tag(petid, petname);
		
		ArrayList<Tag> tags = new ArrayList<>();
	    tags.add(tag);
	       
	    petPayload.setTags(tags);
	    
	    
		
		String[] photourl = {"https://cdn.fotofits.com/petzlover/gallery/img/l/shih-tzu-847861.jpeg"};
		petPayload.setPhotoUrls(photourl);
		
		petPayload.setStatus("available");
	}
	

	
	@Test(priority=1)
	
	public void testAddPet() {
		
		Response response = PetEndpoints.addPet(petPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2, dependsOnMethods = {"testAddPet"})
	
	public void testGetPet() {
		
		Response response = PetEndpoints.getPet(petPayload.getId());
		response.then().log().all();
	}
	
	@Test(priority=3)
	public void testUpdatePet() {
		
	    petPayload.setName(faker.name().name());
	    
	    Category category = new Category(102, "pomranien");
	    petPayload.setCategory(category);
	    
	    int petid = petPayload.getId();
	    String petname = petPayload.getName();
	    Tag tag = new Tag(petid, petname);
	    ArrayList<Tag> tags = new ArrayList<>();
	    tags.add(tag);  
	    petPayload.setTags(tags);
	    
	    Response response = PetEndpoints.updatePet(petPayload);
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but found " + response.getStatusCode());
	    
	    Response response_after = PetEndpoints.getPet(this.petPayload.getId());
	    response_after.then().log().all();
	}
	
	@Test(priority=4, dependsOnMethods = {"testUpdatePet"})
	
	public void testDeletePet() {
		
		Response response = PetEndpoints.deletePet(petPayload.getId());
		response.then().log().all();
		
	}

}
