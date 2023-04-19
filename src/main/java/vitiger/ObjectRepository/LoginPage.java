package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	//Rule1: create a POM class for every web page
	public class LoginPage {
	//Rule2: identify the web element with @FindBy,@FindByall,@FindBys
		@FindBy(name = "user_name")
		private WebElement usernameEdt;
		
		@FindAll({@FindBy(name = "user_password"),@FindBy(xpath="//input[@type='password']")})
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement submitBtn;
		
		//Rule3: Create a constructor to initialise these web element??/???????? it dosen't have any return type with r with out args
			public LoginPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}



			public WebElement getUsernameEdt() {
				return usernameEdt;
			}

			public WebElement getPasswordEdt() {
				return passwordEdt;
			}

			public WebElement getSubmitBtn() {
				return submitBtn;
			}
		//Business Libraries - generic methods specific to current project
			public void loginToApp(String Username, String Password)
			{
				usernameEdt.sendKeys(Username);
				passwordEdt.sendKeys(Password);
				submitBtn.click();
			}

}
