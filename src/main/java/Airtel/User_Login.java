package Airtel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Login {
	WebDriver driver;

	public User_Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Username']")
	WebElement Username;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(className = "btn")
	WebElement Submit;

	public void userLoginCp(String UsernameCp, String UserPassword) {
		this.Username.sendKeys(UsernameCp);
		this.Password.sendKeys(UserPassword);
		Submit.click();
	}

	public void userLoginDe(String UsernameDe, String UserPassword) {
		this.Username.sendKeys(UsernameDe);
		this.Password.sendKeys(UserPassword);
		Submit.click();
	}

	public void goTo() {
		driver.get("https://kyctest.airtel.africa/kyc-ne/#!/login");
	}

}
