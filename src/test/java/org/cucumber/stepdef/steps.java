package org.cucumber.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.testng.Assert;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import cucumber.api.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {
	WebDriver driver=null;
	@Given("^User is signedin to gmail account$")
	public void User_is_signedin_to_gmail_account() throws Throwable {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	   
	    driver.get("https://gmail.com");   
        driver.findElement(By.xpath("//input[@id='identifierId']	")).sendKeys("abc@gmail.com");	
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click(); 
        
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("xyz");	
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click(); 
	    
	}
	
	@When("^User clicks on compose$")
	public void User_clicks_on_compose() throws Throwable {
	
		String winHandleBefore = driver.getWindowHandle();
	   	 
        driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();	
        
     // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);}
	}
	
	@And("^User enters \"(.*)\" \"(.*)\" and \"(.*)\"$")
	public void User_enters_recipientemail_subject_body() throws Throwable {
        driver.findElement(By.xpath(" //input[@id=':tf']")).sendKeys("recipientemail");	
        driver.findElement(By.xpath("//input[@id=':pt']")).sendKeys("subject");
        driver.findElement(By.xpath("//div[@id=':r3']")).sendKeys("body");  
            
	}
		
	@And("^User clicks on send button$")
	public void User_clicks_on_send_button() throws Throwable {
	
		driver.findElement(By.xpath("//div[@id=':pj']")).click();	
			
	}
	
	@Then("^Message displayed Message Sent$")
	public void Message_displayed_Message_Sent() throws Throwable {
	
		String actualmessage=driver.findElement(By.xpath("//span[@class='bAq']")).getText();
		String expectedmessage = "Message sent";
		Assert.assertEquals(actualmessage, expectedmessage);
	

}
	@Then("^Signout from gmail$")
	public void Signout_from_gmail() throws Throwable {
		driver.findElement(By.xpath("//a[@class='gb_d gb_Fa gb_J']")).click();	
		driver.findElement(By.xpath("//a[@class='V5tzAf jFfZdd Dn5Ezd']")).click();			
		
	} 

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		
		driver.quit();
}
}