package stepdefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import utility.UtilityHelper;

public class BeforeClass {

	private String scenDesc;
	public static Properties prop = new Properties();
	public static Properties log4jprop = new Properties();
	final static Logger log = Logger.getLogger("devpinoyLogger");
	public static String jsonPath;
	
	 @Before
		public void before(Scenario scenario) {
	 				this.scenDesc = scenario.getName();
	 				try {
	 		    		prop.load( new FileInputStream("./src/test/resources/config/application.properties") );
	 		    		log4jprop.load(new FileInputStream("./src/test/resources/config/log4j.properties"));	
	 		    		PropertyConfigurator.configure(log4jprop);
	 		    		
	 		    		jsonPath=prop.getProperty("Jsonpath");
	 		    		
	 		    	} catch (IOException e) {
	 					e.printStackTrace();
	 				}
	 			}
	 			
	 public static String getJsonPath()
	 {
		 return jsonPath;
	 }
	 
			
			
		
	  
	  @After
	  public void after(Scenario scenario){
		 System.out.println ( scenario.getStatus());
	  	
	  }
		
		
		 

}
