package getRequestValidationTest;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Post_ValidateNewCountryAddUsing {
	
	@Test
	public void getnonExistingCountry(){
		try{
			  Map<String,String> addCountry = new HashMap<String,String>();
			  addCountry.put("name", "Test Country");
			  addCountry.put("alpha2_code", "TC");
			  addCountry.put("alpha3_code", "TCY");

		     RestAssured.given()
		        .contentType("application/json")
		        .body(addCountry)
		        .when().post("/addCountry").then()
		        .statusCode(201);
		     
		     Reporter.log("New country is added and response is 201 " , true);

		}
		catch (Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
	}

}
