package features;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
	private static WebDriver driver = null;

	@Given("^system navaigates in login page$")
	public void system_navaigates_in_login_page() throws Throwable {
		DesiredCapabilities caps = new DesiredCapabilities();

		driver = new FirefoxDriver();

		System.setProperty        
		("webdriver.gecko.driver","C:\\Users\\lethi\\Desktop\\settings\\mars workspace\\cucumber_training\\geckodriver.exe"); 
		caps=DesiredCapabilities.firefox();
		caps.setCapability("marionette", true);
		driver = new FirefoxDriver(caps);

		//Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Launch the Online Store Website

		driver.get("http://www.store.demoqa.com");

		// Find the element that's ID attribute is 'account'(My Account) 

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		// Find the element that's ID attribute is 'log' (Username)



		//		// Find the element that's ID attribute is 'account_logout' (Log Out)
		//
		//		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
		//
		//		// Print a Log In message to the screen

		//	System.out.println("LogOut Successfully");


	}

	@When("^an invalid user and password are entere$")
	public void an_invalid_user_and_password_are_entere() throws Throwable {

		// Enter Username on the element found by above desc.

		driver.findElement(By.id("log")).sendKeys("testuser10000"); 

		// Find the element that's ID attribute is 'pwd' (Password)

		// Enter Password on the element found by the above desc.

		driver.findElement(By.id("pwd")).sendKeys("Test@123");

	}

	@When("^login button is clicked$")
	public void login_button_is_clicked() throws Throwable {
		// Now submit the form. WebDriver will find the form for us from the element 

		driver.findElement(By.id("login")).click();


	}

	@Then("^an error message is returned$")
	public void an_error_message_is_returned() throws Throwable {
		// Close the driver
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Your Account | ONLINE STORE"));//(By.className("response")).isDisplayed());//(".//*[@id='ajax_loginform']/p[1]")).isDisplayed());
		driver.close();
	}
}
