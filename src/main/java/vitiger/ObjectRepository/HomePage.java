package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilites.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomePageRefresh;
	
	@FindBy(linkText = "Calendar")
	private WebElement CalendarLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
		
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getHomePageRefresh() {
		return HomePageRefresh;
	}

	public WebElement getCalendarLnk() {
		return CalendarLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getOrganizationLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	
	//Business Libraries
	/**
	 * this method will perform click operation on Organizations link
	 */
	public void clickOnOrganizationsLnk()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * this method will perform Logout operation
	 */
	public void clickOnContactsLnk()
	{
		ContactsLnk.click();
	}
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
		
	}
	
}
