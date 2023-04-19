package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureShcreenShot {
	public static void main(String[] args) {
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
				
		driver.quit();
	}

}
