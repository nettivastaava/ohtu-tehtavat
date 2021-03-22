package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
    	driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void newUserIsCreated(String username, String password) {
    	driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
    
	registerWith(username, password, password);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void newUserIsTriedToBeCreated(String username, String password) {
    	driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
    
	registerWith(username, password, password);
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }   
    
    @When("a too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndMatchingPasswordAreEntered(String username, String password) {
    	registerWith(username, password, password);
    } 
    
    @When("a valid username {string} and a too short password {string} are entered")
    public void validUsernameAndTooShortPasswordAreEntered(String username, String password) {
    	registerWith(username, password, password);
    }
    
    @When("a valid username {string} and mismatching passwords {string} and {string} are given")
    public void validUsernameAndMismatchingPasswordsAreGiven(String username, String password, String wrongConfirmation) {
    	registerWith(username, password, wrongConfirmation);
    }
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorMessageSayingUsernameNeedsToHaveAtLeastThreeCharactersIsShown(String pageContent) {
    	assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }   
    
    @Then("a new user is created")
    public void userIsCreated()  {
    	pageHasContent("Welcome to Ohtu Application!");
    }
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }  
    
    @When("incorrect username {string} and incorrect password {string} are given") 
    public void incorrectUsernameAndIncorrectPasswordAreGiven(String username, String password) {
    	logInWith(username, password);
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndMatchingPasswordAreEntered(String username, String password) {
    	registerWith(username, password, password);
    }
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
    
    private void registerWith(String username, String password, String passwordConfirmation) {
    	assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
}
