package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User endpoints
//used to perform CRUD OPERATIONS---create,Retrieve,update,Delete requests to the user APIS

public class Userendpoints {
	public static Response  Createuser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(routes.post_url);
		
		return response;

}
	
	public static Response Readuser(String userName)
	{
		Response response=given()
				.pathParam("username",userName)
				.when()
				.get(routes.get_url);
		return response;
	}
	
	public static Response updateUser(String userName, User userPayload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",userName)
				
				.when()
				.put(routes.update_url);
		return response;
	}
		
		public static Response deleteUser(String userName)
		{
			Response response=given()
			.pathParam("username",userName)
					
					.when()
					.delete(routes.delete_url);
			return response;
		}

		
		
	
}