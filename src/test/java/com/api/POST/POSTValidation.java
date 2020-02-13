package com.api.POST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTValidation {
	
	
	@Test
	public void enterCustomerDetails() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification httpRequest = RestAssured.given();
	
		//Request payload
		JSONObject requestPrams = new JSONObject();
		
		requestPrams.put("FirstName", "13Ssdgfonia11");
		requestPrams.put("LastName", "1Migsdfgshra");
		requestPrams.put("UserName", "1Ssdfsgdfonia1");
		requestPrams.put("Password", "1Sonia");
		requestPrams.put("Email", "Sonigsda1113@gmail.com");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestPrams.toJSONString()); //attach above data to the request
		
		Response resp = httpRequest.request(Method.POST, "/register");
		
		int statusCode = resp.getStatusCode();
		String statusLine = resp.getStatusLine();
		System.out.println(statusCode+ " " +statusLine);
		String responce = resp.body().asString();
		System.out.println("JSON Body " +responce);
		
		String successCode = resp.jsonPath().get("SuccessCode");
		System.out.println("Successc Code is " +successCode);
		
		String successMessage = resp.jsonPath().get("Message");
		System.out.println("Successc Code is " +successMessage);
		
		Headers head = resp.headers();
		
		for(Header h : head) {
			
			System.out.println(h.getName()+ "  " +h.getValue());
			
		}
		
		
	}

}
