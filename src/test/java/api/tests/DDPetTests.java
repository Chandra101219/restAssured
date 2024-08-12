package api.tests;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.PetEndpoints;
import api.payloads.Pet;
import api.payloads.Pet.Category;
import api.payloads.Pet.Tag;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDPetTests {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void testPostPet(String id, String name,String categoryId, String categoryName, String tagId, String tagname, String photoUrls, String status)
	{
		Pet petPayload=new Pet();
		
		petPayload.setId(Integer.parseInt(id));
		petPayload.setName(name);
		
		//category
		Category category = new Category(Integer.parseInt(categoryId), categoryName);
		petPayload.setCategory(category);
		
		//tag section
		Tag tag = new Tag(Integer.parseInt(tagId), tagname);
		ArrayList<Tag> tags = new ArrayList<>();
	    tags.add(tag);
	       
	    petPayload.setTags(tags);
	    
	    String[] photourl = {photoUrls};
		petPayload.setPhotoUrls(photourl);
		petPayload.setStatus(status);
		
		
		
		Response response=PetEndpoints.addPet(petPayload);
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	
	@Test(priority=2, dataProvider="PetID", dataProviderClass=DataProviders.class)
	public void testDeletePet(String petid)
	{
			Response response=PetEndpoints.deletePet(Integer.parseInt(petid));
			Assert.assertEquals(response.getStatusCode(),200);	
	
	}


}
