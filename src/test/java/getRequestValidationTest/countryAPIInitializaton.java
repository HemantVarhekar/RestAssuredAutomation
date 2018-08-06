package getRequestValidationTest;

import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;
import org.testng.Reporter;

public class countryAPIInitializaton {

	@BeforeTest
	//API base initializer
    public static void setup() {
       try
 		{
 			
 			RestAssured.baseURI = "http://services.groupkt.com/country";
 			Reporter.log( "Base URL http://services.groupkt.com/country is initialized ", true );
 			
 		}
 		catch(Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
	

    }
}
