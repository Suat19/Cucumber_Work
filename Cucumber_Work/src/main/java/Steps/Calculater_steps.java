package Steps;

import Page_Object.Calculater_page;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Calculater_steps {

    private WebDriver driver;
    Calculater_page calculater_page=new Calculater_page();

    @Given("Navigate to Website")
    public void navigateToWebsite() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @And("Click calculate pagebutton")
    public void clickCalculatePagebutton() {
        calculater_page.setCalculatePageButton();
    }

    @And("Type firstnumber {string}")
    public void typeFirstnumber(String firstnumber) {
        calculater_page.setNumber1(firstnumber);
    }

    @And("Type secondnumber {string}")
    public void typeSecondnumber(String secondnumber) {
        calculater_page.setNumber2(secondnumber);
    }

    @And("Choose the type plus")
    public void chooseTheTypePlus() throws InterruptedException {
        calculater_page.setFunction();
    }

    @When("Click calculate button")
    public void clickCalculateButton() {
        calculater_page.setClickButton();
    }

    @Then("Verify  answer message")
    public void verifyAnswerMessage() throws InterruptedException {
        calculater_page.setAnswer();
    }
}
