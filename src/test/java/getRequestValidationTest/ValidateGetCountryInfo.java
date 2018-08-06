package getRequestValidationTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import services.groupkt.countryAPIInitializaton;
import org.testng.Reporter;




//import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ValidateGetCountryInfo extends countryAPIInitializaton {
	
	
	
	//Validate US country response from http://services.groupkt.com/country/get/all
	@Test
	public void testResponseBodyMatchUSA(){
		
		try{
			RestAssured.given().when().get("/get/all").then().assertThat()
			   .body("RestResponse.result.name[235]", equalTo("United States of America"))
			   .body("RestResponse.result.alpha2_code[235]", equalTo("US"))
			   .body("RestResponse.result.alpha3_code[235]", equalTo("USA"));
			 
			
			Reporter.log("US response validated from country/get/all API",true);
		}
		catch(Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
		
		

	}
	
	//Validate GB country response from http://services.groupkt.com/country/get/all
	@Test
	public void testResponseBodyMatchGB(){
		
		try{
			RestAssured.given().when().get("/get/all").then().assertThat()
			   .body("RestResponse.result.name[234]", equalTo("United Kingdom of Great Britain and Northern Ireland"))
			   .body("RestResponse.result.alpha2_code[234]", equalTo("GB"))
			   .body("RestResponse.result.alpha3_code[234]", equalTo("GBR"));
			Reporter.log("GB response validated from country/get/all API",true);
		}
		catch (Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
		

	}
	
	//Validate DE country response from http://services.groupkt.com/country/get/all
	@Test
	public void testResponseBodyMatchDE(){
		
		try{
			RestAssured.given().when().get("/get/all").then().assertThat()
			   .body("RestResponse.result.name[82]", equalTo("Germany"))
			   .body("RestResponse.result.alpha2_code[82]", equalTo("DE"))
			   .body("RestResponse.result.alpha3_code[82]", equalTo("DEU"));
			Reporter.log("DE response validated from country/get/all API" ,true);
		}
		catch (Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
		
						   

	}
	
		
		 
		 
	}


