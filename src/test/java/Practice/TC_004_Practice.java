package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_004_Practice {

	public static void main(String[] args) throws Exception {
		//step1: Launch Browser
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("http://localhost:8888");
		
		 //step2: Login to application with valid credentials
		 driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys("admin", Keys.TAB,"admin",Keys.ENTER);
		
		 //step3: Navigate to Organizations link
		 driver.findElement(By.linkText("Organizations")).click();
		 
		//step4: Click on Create Organization look Up Image
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		//step5: Create Organization with Mandatory fields
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ffSpider");
		
		 //Select "Energy" in the industry drop down
		//Select "Customer" in the Type Drop down 
		 WebElement element = driver.findElement(By.xpath("//select[@name='industry']"));
		 element.click();
		 Select s = new Select(element);
		 //s.selectByIndex();
		 //s.selectByValue();
		 s.selectByVisibleText("Energy");
		 
		 WebElement click = driver.findElement(By.xpath("//select[@name='accounttype']"));
		 element.click();
		 Select e = new Select(click);
		 e.selectByVisibleText("Customer");
		Thread.sleep(5000);
		 //step6 save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String Headermsg =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(Headermsg.contains("ffSpider"))
			{
				System.out.println(Headermsg+"--passed--");
			}
			else
			{
				System.out.println("failed");
			}
		//step7: logout of Application
			WebElement header = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);//mouse actions class
			act.moveToElement(header).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("Sign out successfully");

	}

}
