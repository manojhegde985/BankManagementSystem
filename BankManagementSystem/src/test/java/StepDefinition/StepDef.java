package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	@Given("Admin enters the customer details")
	public void admin_enters_the_customer_details() {
	    System.out.println("Enter customer details");
	}

	@When("Admin sends post http request")
	public void admin_sends_post_http_request() {
	    System.out.println("send the post request");
	}

	@Then("Admin gets valid response")
	public void admin_gets_valid_response() {
	   System.out.println("get the response");
	}

	@When("Admin sends get http request")
	public void admin_sends_get_http_request() {
	    System.out.println("send the get request");
	}

}
