package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilites.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdit;

	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//input [@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will create Organization with OrgName
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdit.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * this method will create Organization with OrgName or IndustryType
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createOrganization(String OrgName, String IndustryType)
	{
		OrgNameEdit.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, IndustryType);
		saveBtn.click();
	}
}
