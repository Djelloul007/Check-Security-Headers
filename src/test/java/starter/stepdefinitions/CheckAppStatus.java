package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Before;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CheckAppStatus {

    @Before
    public void setbaseurl(){
        RestAssured.baseURI="https://bddtrader.herokuapp.com";
    }

    @Given("^(?:.*)the application is running$") //https://bddtrader.herokuapp.com
    public void the_application_is_running() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        SerenityRest.given().relaxedHTTPSValidation().when().get("https://bddtrader.herokuapp.com");
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        SerenityRest.given()
                .when().get("https://bddtrader.herokuapp.com/api/status")
                .then().statusCode(200);
    }

    @Then("the API should return {string}")
    public void the_API_should_return(String string) {
        String Response= SerenityRest.lastResponse().body().asString();
        assertThat(Response).isEqualTo("BDDTrader running against DEV");
    }

    @Step
    @Then("the API should return for the following Securityheadername (.*) with the value (.*)")
    public void the_API_should_return_the_following_Securityheaders(String Securityheadername, String Securityheadervalue) {
        String Response= SerenityRest.lastResponse().header(Securityheadername).toString();
        assertThat(Response).isEqualTo(Securityheadervalue);
    }
}
