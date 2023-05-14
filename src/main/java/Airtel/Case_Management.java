package Airtel;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Case_Management {

	WebDriver driver;

	public Case_Management(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "newSize")
	@CacheLookup
	WebElement OpenCaseDE;

	@FindBy(name = "amService")
	@CacheLookup
	WebElement AMService;

	@FindBy(name = "gender")
	@CacheLookup
	WebElement Gender;

	@FindBy(xpath = "//input[@placeholder='Select Date of ID Issue']")
	@CacheLookup
	WebElement DateOfIdIssue;

	@FindBy(id = "idIssueAuthority")
	@CacheLookup
	WebElement IdIssueAuthority;

	@FindBy(className = "btn-success")
	@CacheLookup
	WebElement Submit;

	@FindBy(id = "showNotificationOk")
	@CacheLookup
	WebElement showNotificationOk;

	@FindBy(css = "a.capitalize")
	@CacheLookup
	WebElement PreLogout;

	@FindBy(css = "a[ng-click='logout()']")
	@CacheLookup
	WebElement LogOut;

	public void DEOpenCase(String AMServiceForm, String Gender, String IdIssueAuthority, String month, String day)
			throws InterruptedException {

		OpenCaseDE.click();

		int count = 0;
		int loopcount = 0;

		while (count == 0 && loopcount <= 5) {
			loopcount++;
			try {
				if (driver.findElements(By.xpath("//button[text()='Assign Cases']")).size() != 0) {
					driver.findElement(By.xpath("//button[text()='Assign Cases']")).click();
					if (driver.findElements(By.className("fa-edit")).size() != 0) {
						count = 1;
					} else {
						count = 0;
					}
				} else {
					count = 1;
				}
			} catch (Exception e) {
				count = 0;
			}
		}
		if (count == 1) {
			driver.findElement(By.className("fa-edit")).click();
			
			Select amservice = new Select(this.AMService);
			amservice.selectByVisibleText(AMServiceForm);

			Select gender = new Select(this.Gender);
			gender.selectByVisibleText(Gender);

			this.DateOfIdIssue.click();

			while (true) {
				String Text = (driver.findElement(By.xpath(
						"//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/fieldset[3]/div[3]/div[2]/div[1]/datepicker[1]/div[1]/div[1]/div[2]"))
						.getText());
				if (Text.equals(month)) {
					break;
				} else {
					driver.findElement(By.xpath(
							"//*[@id=\"subscriberForm\"]/div[1]/div/div[2]/fieldset[3]/div[3]/div[2]/div/datepicker/div/div[1]/div[1]/a/b"))
							.click();
				}
			}
			driver.findElement(By.xpath(
					"//div[@class='_720kb-datepicker-calendar _720kb-datepicker-open']//div[@class='_720kb-datepicker-calendar-body']//a[contains(text(),"
							+ day + ")]"))
					.click(); // passing parameter to xpath "+day+"

			this.IdIssueAuthority.sendKeys(IdIssueAuthority);
			Thread.sleep(15000);
			this.Submit.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("showNotificationOk")));

			element.click();

			this.PreLogout.click();
			this.LogOut.click();
			driver.close();
		}
	}
}

