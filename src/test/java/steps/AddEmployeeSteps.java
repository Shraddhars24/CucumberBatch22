package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends BaseClass {

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        WebElement firstname=driver.findElement(By.id("firstName"));
        firstname.sendKeys("Mark");
        WebElement lastname =driver.findElement(By.id("lastName"));
        lastname.sendKeys("Jacob");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton =driver.findElement(By.id("btnSave"));
        saveButton.click();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstNameLocator=driver.findElement(By.id("firstName"));
        firstNameLocator.sendKeys("Mark");
        WebElement middleNameLocator=driver.findElement(By.id("middleName"));
        middleNameLocator.sendKeys("Anthony");
        WebElement lastNameLocator=driver.findElement(By.id("lastName"));
        lastNameLocator.sendKeys("Jacob");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        System.out.println("User enters invalid userName and Password");
    }
    @Then("user can see error message")
    public void user_can_see_error_message() {
        System.out.println("User can see Error Message");
    }

    @When("user enters {string} and {string} and {string} in the application")
    public void user_enters_and_and_in_the_application
            (String firstName, String middleName, String lastName) {
        WebElement firstNameLocator=driver.findElement(By.id("firstName"));
        WebElement middleNameLocator=driver.findElement(By.id("middleName"));
        WebElement lastNameLocator=driver.findElement(By.id("lastName"));

        firstNameLocator.sendKeys(firstName);
        middleNameLocator.sendKeys(middleName);
        lastNameLocator.sendKeys(lastName);
    }

    @When("user add {string},{string} and {string}")
    public void user_add_and
            (String fn, String mn, String ln) {
        WebElement firstNameLocator=driver.findElement(By.id("firstName"));
        WebElement middleNameLocator=driver.findElement(By.id("middleName"));
        WebElement lastNameLocator=driver.findElement(By.id("lastName"));

        firstNameLocator.sendKeys(fn);
        middleNameLocator.sendKeys(mn);
        lastNameLocator.sendKeys(ln);
    }

    @When("user adds multiple employees using data table and save them")
    public void user_adds_multiple_employees_using_data_table_and_save_them
            (io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> employeeNames = dataTable.asMaps();

        for (Map<String,String> employee:employeeNames){
            WebElement firstNameLocator=driver.findElement(By.id("firstName"));
            WebElement middleNameLocator=driver.findElement(By.id("middleName"));
            WebElement lastNameLocator=driver.findElement(By.id("lastName"));

            firstNameLocator.sendKeys(employee.get("firstName"));
            middleNameLocator.sendKeys(employee.get("middleName"));
            lastNameLocator.sendKeys(employee.get("lastName"));

            WebElement saveButton =driver.findElement(By.id("btnSave"));
            saveButton.click();

            WebElement addEmpoption =driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpoption.click();


        }

    }

    @When("user adds multiple employees from excel file")
    public void user_adds_multiple_employees_from_excel_file() throws IOException {
        List<Map<String,String>> newEmployees = ExcelReader.read();
        for (Map<String,String> employee:newEmployees){

            WebElement firstNameLocator=driver.findElement(By.id("firstName"));
            WebElement middleNameLocator=driver.findElement(By.id("middleName"));
            WebElement lastNameLocator=driver.findElement(By.id("lastName"));

            firstNameLocator.sendKeys(employee.get("firstName"));
            middleNameLocator.sendKeys(employee.get("middleName"));
            lastNameLocator.sendKeys(employee.get("lastName"));

            WebElement saveButton =driver.findElement(By.id("btnSave"));
            saveButton.click();

            WebElement addEmpoption =driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpoption.click();

        }
    }

}
