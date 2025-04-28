package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

/*public WebDriver driver;*/
    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

    }


    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebElement userNameField=driver.findElement(By.id("txtUsername"));
               // userNameField.sendKeys("admin");
        sendText(ConfigReader.read("userName"),userNameField);

        WebElement passwordField=driver.findElement(By.id("txtPassword"));
        //passwordField.sendKeys("Hum@nhrm123");
        sendText(ConfigReader.read("password"),passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       WebElement loginButton= driver.findElement(By.id("btnLogin"));
       //loginButton.click();
       click(loginButton);

    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        System.out.println("Test passed");
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption= driver.findElement(By.id("menu_pim_viewPimModule"));
        //pimOption.click();
        click(pimOption);
    }
    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpoption =driver.findElement(By.id("menu_pim_addEmployee"));
        //addEmpoption.click();
        click(addEmpoption);
    }








}
