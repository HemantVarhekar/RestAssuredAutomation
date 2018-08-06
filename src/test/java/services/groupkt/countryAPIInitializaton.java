package services.groupkt;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class countryAPIInitializaton {

	@BeforeClass
	//API base initializer
    public static void setup() {
       try
 		{
 			
 			RestAssured.baseURI = "http://services.groupkt.com/country";
 			
 		}
 		catch(Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println("=================");
 			e.printStackTrace();
 		}
	

    }
}
