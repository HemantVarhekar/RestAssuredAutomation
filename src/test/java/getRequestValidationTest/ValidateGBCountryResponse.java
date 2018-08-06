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

public class ValidateGBCountryResponse extends countryAPIInitializaton {
	
		@Test
	 	public void getCallGBCheck(){
	 		
//Get the entire response from :http://services.groupkt.com/country/get/all
	 		
	 		try{
	 			Response response =
		 				RestAssured.given()
		 				           .when()
		 				           .get("/get/all/")
		 				           .then()
		 				           .contentType(ContentType.JSON)
		 				           .extract().response();
		 		
		 		//Extract  getGBCountry =GB from Response
		 		String getGBCountry = response.path("RestResponse.result.alpha2_code[234]");
		 		
		 		
		 		//Passing the value getGBCountry =GB and validating the entire response
		 		RestAssured.given().when().get("/get/iso2code/"+getGBCountry).then().assertThat()
		 						.body("RestResponse.messages", hasItems("Country found matching code [GB]."))
		 						.body("RestResponse.result.name",equalTo("United Kingdom of Great Britain and Northern Ireland"))
		 						.body("RestResponse.result.alpha2_code",equalTo("GB"))
		 						.body("RestResponse.result.alpha3_code",equalTo("GBR"))
		 						.statusCode(200);

		 		Reporter.log("GB country is fetched and response is validated from /get/iso2code/GB" , true );
	 		}
			catch (Exception e)
	 		{
	 			System.out.println(e.getMessage());
	 			System.out.println("=================");
	 			e.printStackTrace();
	 		}
			
			
			
	}
	
		 
	}


