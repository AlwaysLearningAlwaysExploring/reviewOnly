package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.LoginPage;

public class LoginPage_PF {
		
	
	
	@FindBy(id="name") WebElement txt_username;
	@FindBy(id = "password") WebElement txt_password;
	@FindBy(id="login") WebElement btn_login;
	WebDriver driver;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		if (!driver.getTitle().equals("TestProject Demo")){
			throw new IllegalStateException("This is not the login page. The current page is "+driver.getCurrentUrl());
		}
	}
	
	public void enterLoginCredentials(String username, String password) throws InterruptedException {
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		
		Thread.sleep(2000);
	}
	public void clickLogin() {
		btn_login.click();
	}
}
