package Airtel;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{

	public WebDriver driver;
	
	public WebDriver IntializationDriver() throws IOException{
		
//		Properties prop = new Properties();
//		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+("\\src\\Resources\\GlobalData.properties")); //driver location
//		prop.load(fis);
//		String BrowserName=prop.getProperty("browser");
//		
//		if(BrowserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "D:\\AA\\chromedriver_win32.exe");
//		 driver = new ChromeDriver();
//		}
//		
//		else if(BrowserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", "D:\\java workspace\\browser driver\\msedgedriver.exe");
//			 driver = new EdgeDriver();
//		}
//		else if(BrowserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "D:\\java workspace\\browser driver\\geckodriver.exe");
//			 driver = new FirefoxDriver();
//		}
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
		
	}

	public void LaunchApplication() throws IOException {
		driver= IntializationDriver();
	}
}


