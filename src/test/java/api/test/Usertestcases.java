package api.test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class Usertestcases {
	
	Faker faker;
	User userPayload;
	@BeforeClass 
	public void setupdata()
	{
		faker=new Faker();
		 userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5,10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	
	}
	@Test(priority=1)
	public void testPostuser()
	{
	Response response=Userendpoints.Createuser(userPayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testGetuser()
	{
		Response response=Userendpoints.Readuser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=3)
	public void testUpdateuserByName()
{
//update the below data using payload
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response= Userendpoints.updateUser(this.userPayload.getUsername(),userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
		//checking the data after update
		Response responseAfterUpdate=Userendpoints.updateUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		}
@Test(priority=4)
public void testdeleteuserByName()
{
	Response.response=Userendpoints.deleteUser(this.userPayload.getUsername());
	Assert.assertEquals(response.getStatusCode(),200);
	
}
}
