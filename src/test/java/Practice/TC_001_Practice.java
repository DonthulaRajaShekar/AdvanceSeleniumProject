package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import vitiger.GenericUtilites.ExcelFileUtility;
import vitiger.GenericUtilites.JavaUtility;

import vitiger.GenericUtilites.WebDriverUtility;

public class TC_001_Practice {

	public static void main(String[] args) throws Exception {
		//Step1: Launch Browser
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("http://localhost:8888");
	
		//Step2: Login into application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin", Keys.TAB, "admin",Keys.ENTER);
		
		//step3: Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step4: click on Create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step5: create contacts list with mandatory field
		driver.findElement(By.name("lastname")).sendKeys("RajaShekar");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step6: verification for contact
		String ContainsHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContainsHeader.contains("RajaShekar"))
		{
			System.out.println(ContainsHeader+"---passed---");
		}
		else
		{
			System.out.println("---fail---");
		}
		
		//logout of app
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("Sign out successfully");
		
				
		
		
	}

}
