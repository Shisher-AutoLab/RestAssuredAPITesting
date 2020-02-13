package com.api.GET;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherValidationGet {

	@Test
	public void validateWeather() {
		try {
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

			// Request object
			RequestSpecification httpRequest = RestAssured.given();

			
			// Responce object
			Response resp = httpRequest.request(Method.GET, "/Pune");

			// Print responce
			String responceBody = resp.getBody().asString();
			System.out.println(responceBody);
			
			//Status code validation
			int statusCode = resp.getStatusCode();
			System.out.println("Status code is " +statusCode);
			Assert.assertEquals(200, 200, "Status code is correct" +statusCode);
			
			String statusLine = resp.getStatusLine();
			System.out.println("Status line is " +statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line isshowing correct" +statusLine);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
