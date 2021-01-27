package StepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginUdemy {
	
	WebDriver driver = null;
	
	
	@Given("user is no udemy page")
	public void user_is_no_udemy_page() {
		String projectPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

	@When("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException{
		driver.navigate().to("https://www.udemy.com/");
		Thread.sleep(1000);
	}

	@And("user in on login page")
	public void user_in_on_login_page() {
		driver.findElement(By.linkText("Log in")).click();
	}

	@When("user enters email and password")
	public void user_enters_email_and_password() throws InterruptedException{
		driver.findElement(By.name("email")).sendKeys("sonali12negi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("_back_/upto_WT06");
		Thread.sleep(1000);
	}

	@And("clicks on submit button")
	public void clicks_on_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException{
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/div[9]/a[1]/div[1]")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}


}
