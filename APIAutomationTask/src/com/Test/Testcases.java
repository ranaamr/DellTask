package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testcases {
	// to assert on the response code 200
	@Test(priority=1)
	public void assertStatusCodeOFGetTVGategories() {

		given().when().get("http://localhost:3030/categories?name[$like]=*TV*").then().assertThat().statusCode(200);

	}

	@Test(priority=2)
	public void assertBodyOFGetTVGategories() {

		given().when().get("http://localhost:3030/categories?name[$like]=*TV*").then().assertThat()
				.body(containsString("TV"));

	}
	// to assert on the content type application is JSON

	@Test(priority=3)
	public void assertOnContentType_JSON() {
		given().when().get("http://localhost:3030/categories?name[$like]=*TV*").then().assertThat()
				.contentType(ContentType.JSON);

	}

	// to assert that the category is created successfully

	@Test(priority=4)
	public void CheckthatCategoryisCreatedSuccessfully() {
		RestAssured.baseURI = "http://localhost:3030/categories";
		Response res = given().contentType("application/json").body("{\"id\":\"id006\",\"name\":\"new category\"}")
				.when().post("");
		String body = res.getBody().asString();
		System.out.println(body);
		Assert.assertTrue(body.contains("id006"));
		
			 
	    

	}
}