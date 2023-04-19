package vitiger.GenericUtilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.LoginPage;
/**
 * This class consists of Basic configuration annotations of TestNG
 * @author HP
 *
 */
public class BaseClass {
	public propertyFileUtility pUtil = new propertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public static WebDriver sDriver; //Listeners
	
	public WebDriver driver;
	
	@BeforeSuite(groups = "smokeSuite")
	public void bsConfig() {
		System.out.println("---Data connection successfully---");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = "smokeSuite")
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		// Step 2: Launch the browser - runtime polymorphism
				if (BROWSER.equalsIgnoreCase("chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("----- "+BROWSER+" Launched succesfully-----");	
				}
				else if (BROWSER.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("----- "+BROWSER+" Launched successfully-----");	
				}
				else 
				{
					System.out.println("Invalid Browser name");
				}
				
				sDriver=driver; //listeners
				wUtil.maximizeWindow(driver);
				wUtil.WaitForPage(driver);
				driver.get(URL);
		}
	
	@BeforeMethod(groups = "smokeSuite")
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login successful -----");
	}

	@AfterMethod(groups = "smokeSuite")
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----- Logout successful -----");	
	}
	@AfterTest
	//@AfterClass(groups = "smokeSuite")
	public void acConfig() {
		driver.quit();
		System.out.println("----- Browser Closed successfully -----");
	}
	
	@AfterSuite(groups = "smokeSuite")
	public void asConfig() {
		System.out.println("----- Database Connection successfull -----");
	}
}
