package getRequestValidationTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import services.groupkt.countryAPIInitializaton;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ValidateInexistanceCountry extends countryAPIInitializaton  {
	
	static String invalidCountry = "ABC";
	@Test
	public void getnonExistingCountry(){
		
		try{
			RestAssured.given().get("/get/iso2code/"+invalidCountry).then().assertThat()
			   .body("RestResponse.messages", hasItems("No matching country found for requested code [ABC]."))
			   .statusCode(404);
			//int resp = RestAssured.given().get("/get/iso2code/"+invalidCountry).getStatusCode();	
			
			Reporter.log("No matching country is found" , true );
		}
		catch (Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
		
		
		
		
		
	}
	

}
