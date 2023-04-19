package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_005_Practice {

	public static void main(String[] args) throws InterruptedException {
		//Step1: Launch Browser
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("http://localhost:8888");
		
		//Step2: Login to application with valid credentials
		 driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys("admin", Keys.TAB,"admin",Keys.ENTER);
			
		//Step3: Navigate to Contacts link
		 driver.findElement(By.linkText("Contacts")).click();
		 
		//Step4: Click on Create contact look up image
		 driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		 
		//Step5: Create contact with manadatory fields
		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("TRYSpider");
			
		//Step6: Select the Organization from organization look up image
		  driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();     
		Thread.sleep(3000);
		//Step7: Save and verify
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 String Headermsg =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(Headermsg.contains("TRYSpider"))
				{
					System.out.println(Headermsg+"--passed--");
				}
				else
				{
					System.out.println("failed");
				}

	}

}
