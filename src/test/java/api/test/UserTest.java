package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void postUser() {
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
	}
	
	@Test(priority=2)
	public void getUser() {
		Response response=UserEndPoints.getUser(userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
		
	}
	
	@Test(priority=3)
	public void updateUser() {
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response=UserEndPoints.updateUser(userpayload, userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
		
		Response responseAfterUpdate = UserEndPoints.createUser(userpayload);
		responseAfterUpdate.then().log().all();
	}
	
	@Test(priority = 4)
	public void deleteUser() {
		Response response=UserEndPoints.deleteUser(userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}

}
