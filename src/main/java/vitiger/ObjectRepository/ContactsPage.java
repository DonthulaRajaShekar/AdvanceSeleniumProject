package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
			@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement CreateContactLookUpImg;
			
			//initialization
			public ContactsPage(WebDriver driver) {
			  PageFactory.initElements(driver, this);	
			}

			//Utilization
			public WebElement getCreateOrgLookUpImg() {
				return CreateContactLookUpImg;
			}
		    
			
		//Business Library
		/**
		 * This method will perform click operation on create Org look up image
		 */
			
		public void clickOnCreateContactImg()
		{
			CreateContactLookUpImg.click();
		}

}
