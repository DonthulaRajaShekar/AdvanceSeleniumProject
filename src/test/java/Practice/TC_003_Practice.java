package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_003_Practice {

	public static void main(String[] args) throws Exception {
		//Step1: Launch Browser
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("http://localhost:8888");
		
		//Step2: Login to application with valid credentials
		 driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys("admin", Keys.TAB,"admin",Keys.ENTER);
		
		//Step3: Navigate to Organizations link
		 driver.findElement(By.linkText("Organizations")).click();
		 
		//Step4: Click on Create Organization look Up Image
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step5: Create Organization with Mandatory fields
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("jabbarSpider");
		
		//Step6: Select "Chemicals" in the industry drop down
		 WebElement element = driver.findElement(By.xpath("//select[@name='industry']"));
		 element.click();
		 Select s = new Select(element);//drop down method
		 /*s.selectByValue("");
		 s.selectByIndex();*/
		 s.selectByVisibleText("Chemicals");
		 Thread.sleep(5000);
		//Step7Save and Verify
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String Headermsg =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(Headermsg.contains("jabbarSpider"))
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
