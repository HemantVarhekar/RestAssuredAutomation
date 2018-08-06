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


public class ValidateDECountryResponse extends countryAPIInitializaton {
	
		@Test
	 	public void getCallDECheck(){
			
			try{
				//Get the entire response from :http://services.groupkt.com/country/get/all
		 		
		 		Response response =
		 				RestAssured.given()
		 				           .when()
		 				           .get("/get/all/")
		 				           .then()
		 				           .contentType(ContentType.JSON)
		 				           .extract().response();
		 		
		 		//Extract  getDECountry =DE from Response
		 		String getDECountry = response.path("RestResponse.result.alpha2_code[82]");
		 		
		 		
		 		//Passing the value getDECountry =DE and validating the entire response
		 		RestAssured.given().when().get("/get/iso2code/"+getDECountry).then().assertThat()
		 						.body("RestResponse.messages", hasItems("Country found matching code [DE]."))
		 						.body("RestResponse.result.name",equalTo("Germany"))
		 						.body("RestResponse.result.alpha2_code",equalTo("DE"))
		 						.body("RestResponse.result.alpha3_code",equalTo("DEU"))
		 						.statusCode(200);
		 		Reporter.log("DE country is fetched and response is validated from /get/iso2code/DE" , true );
	
			}
	 		 catch(Exception e)
	 		{
	 			System.out.println(e.getMessage());
	 			System.out.println("=================");
	 			e.printStackTrace();
	 		}
			
			

	}
	
		 
	}


