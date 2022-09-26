package responsevalidator;
import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import stepdefs.BeforeClass;

import java.io.FileReader;

public class RcbValidator {
	JSONArray player;
	   final static Logger log = Logger.getLogger("devpinoyLogger");
	   public static Properties prop = new Properties();
	
	  public void getJsonFile() throws ParseException, IOException {
		 JSONParser jsonparser=new JSONParser();
		  log.info("Getting the json file from project folder");
				  FileReader file=new FileReader("."+BeforeClass.jsonPath);
		  log.info("Json file present in the path... " + BeforeClass.jsonPath);		
		  Object obj=jsonparser.parse(file);
		  JSONObject rcb=(JSONObject)obj;
		String location=  (String) rcb.get("location");
		log.info(location);
		  log.info("setting the player array");
		 player=(JSONArray)rcb.get("player");
		 log.info("player list is .."+player);
		
	  }
	  
	  public int getCountry()
	  {
		  int foreignPlayercount=0;
		  log.info("Interating the player array");
		  for (int i=0;i<player.size();i++)
		  {
			  JSONObject countryName=(JSONObject)player.get(i);
		String playercountryName=(String)countryName.get("country");
		
		if(!(playercountryName.equalsIgnoreCase("India")))
		{
			foreignPlayercount=foreignPlayercount+1;
		}
		
			 
		  }
		  return foreignPlayercount;
	  }
	  
	  
	  public int getWicketKeeper()
	  {
		  int getWicketKeeper=0;
		  log.info("Interating the player array to fetch wicket keeper role");
		  for (int i=0;i<player.size();i++)
		  {
			  JSONObject playerRole=(JSONObject)player.get(i);
		String playerRolecode=(String)playerRole.get("role");
		
		if(playerRolecode.equalsIgnoreCase("Wicket-keeper"))
		{
			getWicketKeeper=getWicketKeeper+1;
		}
		
			 
		  }
		  return getWicketKeeper;
	  }
	  
}
