package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_002_Practice {

	public static void main(String[] args) {
		
		//Step1: Launch Browser
			 WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 driver.get("http://localhost:8888");
			 	
		//Step2: Login to application with valid credentials
			driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys("admin", Keys.TAB,"admin",Keys.ENTER);
			
		//Navigate to Organizations link
			driver.findElement(By.linkText("Organizations")).click();
			
		//Click on Create Organization look Up Image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Create Organization with Mandatory fields
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("JSpider");
			driver.findElement(By.xpath("//input[@value='T']")).click();
		
		//Save and Verify
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String Headermsg =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(Headermsg.contains("JSpider"))
			{
				System.out.println(Headermsg+"--passed--");
			}
			else
			{
				System.out.println("failed");
			}
			//logout of Application
			WebElement header = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);//mouse actions class
			act.moveToElement(header).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("Sign out successfully");
				

	}

}
