package Airtel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Customer_Details {
	WebDriver driver;
	
	public Customer_Details(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Customer Registration']")
	@CacheLookup
	WebElement CustomerRegistrationClick;
	
	@FindBy(xpath="//input[@Placeholder='Enter MSISDN']")
	@CacheLookup
	WebElement MSISDN;
	
	@FindBy(xpath="//input[@placeholder='Enter Sim Serial Number']")
	@CacheLookup
	WebElement SimSerialNumber;
	
	@FindBy(css="input[placeholder='Enter First Name']")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(css="input[placeholder='Enter Last Name']")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(css="textarea[placeholder='Enter physical address']")
	@CacheLookup
	WebElement Address;
	
	@FindBy(className ="idType")
	@CacheLookup
	WebElement IdType;
	
	@FindBy(id="idNumber")
	@CacheLookup
	WebElement IdNumber;
	
	@FindBy(className ="amAccount")
	@CacheLookup
	WebElement AmAccount;
	
	@FindBy(css="input[id='idImagesFront']")
	@CacheLookup
	WebElement IdImagesFront;
	
	@FindBy(css="input[placeholder='Place of Birth']")
	@CacheLookup
	WebElement PlaceOfBirth;
	
	@FindBy(css="input[type='checkbox']")
	@CacheLookup
	WebElement Checkbox;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	@CacheLookup
	WebElement Submit;
	
	@FindBy(id="showNotificationOk")
	@CacheLookup
	WebElement ShowNotificationOk;
	
	@FindBy(xpath="//div/ul/li[3]")
	@CacheLookup
	WebElement DropdownLogout;
	
	@FindBy(css="a[ng-click='logout()']")
	@CacheLookup
	WebElement Logout;
	
	

	
	public void customerDetails(String MSISDN ,String SimSerialNumber ,String FirstName ,String LastName,
			 String Address ,String indexForAm ,String indexForIdType,String IdNumber, String IdImagesFront ,String PlaceOfBirth ) {
		CustomerRegistrationClick.click();
		this.MSISDN.sendKeys(MSISDN);
		this.SimSerialNumber.sendKeys(SimSerialNumber);
		this.FirstName.sendKeys(FirstName);
		this.LastName.sendKeys(LastName);
		this.Address.sendKeys(Address);
		
		WebElement staticAirtelMoney = driver.findElement(By.name("amAccount"));
		this.AmAccount=staticAirtelMoney;
		Select AirtelMoney = new Select(this.AmAccount);
		int amindex = Integer.parseInt(indexForAm);
		AirtelMoney.selectByIndex(amindex);
		
		WebElement staticidtype = driver.findElement(By.name("idType"));
		this.IdType=staticidtype;
		Select idtype = new Select(this.IdType);
		int idtypeindex = Integer.parseInt(indexForIdType);
		idtype.selectByIndex(idtypeindex);
		
		this.IdNumber.sendKeys(IdNumber);
		
		this.IdImagesFront.sendKeys(IdImagesFront);     
	
		this.PlaceOfBirth.sendKeys(PlaceOfBirth);
		this.Checkbox.click();
		this.Submit.click();
		this.ShowNotificationOk.click();
		this.DropdownLogout.click();
		this.Logout.click();
		
		
	}
	
	
}
