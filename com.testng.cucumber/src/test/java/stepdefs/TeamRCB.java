package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import responsevalidator.RcbValidator;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.BeforeStep;
public class TeamRCB {
	   RcbValidator rc=new RcbValidator();

   final static Logger log = Logger.getLogger("devpinoyLogger");
@Given("The team RCB has submitted its team for an upcoming match")
public void teamrcb_submitted() throws JsonParseException, JsonMappingException, IOException, ParseException, org.json.simple.parser.ParseException {
    // Write code here that turns the phrase above into concrete actions
	log.info("Starting the validation step 1");
	rc.getJsonFile();
   
}
@Then ("verify the team has only 4 foreign players")
public void verify_the_team_has_foreign_players() {
    // Write code here that turns the phrase above into concrete actions
	
	System.out.println("Number of foreign player in the team is "+rc.getCountry());
	log.info("Number of foreign player in the team is "+rc.getCountry());
	
	assertTrue(rc.getCountry()==4);
}

@Then("verify that there is at least one wicket keeper")
public void verify_there_one_wicket_keeper() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Number of wicket Keeper in the team is "+rc.getWicketKeeper());
	assertTrue(rc.getWicketKeeper()>=1);
 
}

    
}
