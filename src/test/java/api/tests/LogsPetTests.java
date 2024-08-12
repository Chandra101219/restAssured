package api.tests;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndpoints;
import api.payloads.Pet;
import api.payloads.Pet.Category;
import api.payloads.Pet.Tag;
import io.restassured.response.Response;

public class LogsPetTests {

	Faker faker;
	Pet petPayload;
	public Logger logger; //logs
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		petPayload=new Pet();
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setName(faker.name().name());
		
		
		//category
		Category category = new Category(102, "pomranian");
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
		
		//logs
		logger= LogManager.getLogger(this.getClass());
				
		logger.debug("debugging.....");
	}
	

	
	@Test(priority=1)
	
	public void testAddPet() {
		
		logger.info("********** Adding Pet  ***************");
		
		Response response = PetEndpoints.addPet(petPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** Added Pet  ***************");
	}
	
	@Test(priority=2, dependsOnMethods = {"testAddPet"})
	
	public void testGetPet() {
		logger.info("********** Getting Pet Data ***************");
		
		Response response = PetEndpoints.getPet(petPayload.getId());
		response.then().log().all();
		
		logger.info("********** Pet Data Displayed ***************");
	}
	
	@Test(priority=3)
	public void testUpdatePet() {
		
		logger.info("********** Updating Pet data ***************");
		
	    petPayload.setName(faker.name().name());
	    
	    Category category = new Category(103, "labrador");
	    petPayload.setCategory(category);
	    
	    int petid = petPayload.getId();
	    String petname = petPayload.getName();
	    Tag tag = new Tag(petid, petname);
	    ArrayList<Tag> tags = new ArrayList<>();
	    tags.add(tag);  
	    petPayload.setTags(tags);
	    
	    Response response = PetEndpoints.updatePet(petPayload);
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(), 200);
	    
	    logger.info("********** Pet data Updated ***************");
	    
	    
	    logger.info("********** Getting Updated Pet Data ***************");
	    
	    Response response_after = PetEndpoints.getPet(this.petPayload.getId());
	    response_after.then().log().all();
	    
	    logger.info("********** Updated Pet Data Displayed ***************");
	}
	
	@Test(priority=4, dependsOnMethods = {"testUpdatePet"})
	
	public void testDeletePet() {
		
		logger.info("********** Deleting Pet ***************");
	   
		
		Response response = PetEndpoints.deletePet(petPayload.getId());
		response.then().log().all();
		
		logger.info("********** Deleted Pet ***************");
		
	}
}
