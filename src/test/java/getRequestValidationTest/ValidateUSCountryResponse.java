package getRequestValidationTest;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import services.groupkt.countryAPIInitializaton;
import static org.hamcrest.Matchers.*;

public class ValidateUSCountryResponse extends countryAPIInitializaton {
	
		@Test
	 	public void getCallDECheck(){
	 		
//Get the entire response from :http://services.groupkt.com/country/get/all
	 		
	 		Response response =
	 				RestAssured.given()
	 				           .when()
	 				           .get("/get/all/")
	 				           .then()
	 				           .contentType(ContentType.JSON)
	 				           .extract().response();
	 		
	 		//Extract  getUSCountry =US from Response
	 		String getUSCountry = response.path("RestResponse.result.alpha2_code[235]");
	 		
	 		
	 		//Passing the value getUSCountry =US and validating the entire response
	 		RestAssured.given().when().get("/get/iso2code/"+getUSCountry).then().assertThat()
	 						.body("RestResponse.messages", hasItems("Country found matching code [US]."))
	 						.body("RestResponse.result.name",equalTo("United States of America"))
	 						.body("RestResponse.result.alpha2_code",equalTo("US"))
	 						.body("RestResponse.result.alpha3_code",equalTo("USA"))
	 						.statusCode(200);
	 		Reporter.log("US country is fetched and response is validated from /get/iso2code/US" , true );
	}
	
		 
	}


