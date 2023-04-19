package Vitiger.Organizations;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vitiger.GenericUtilites.BaseClass;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationsPage;
 
@Listeners(vitiger.GenericUtilites.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void CreateOrganizationTest() throws Exception {
				
		//Step2: Read data from excel sheet - Test data */
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		//click on Organization LookUP Img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		//create Organization With Mandatory details
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		// validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		}
	
	@Test(groups = "RegressionSuit")
	public void demoScript()
	{
		System.out.println("Demo");
		//Assert.fail();
	}
	
	
	@Test
	public void regional()
	{
		System.out.println("regional regression");
	}
	
}
