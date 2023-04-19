package Vitiger.Organizations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vitiger.GenericUtilites.BaseClass;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String Org, String INDUSTRY)
	{
		String ORGNAME = Org+jUtil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		Object[][] data = eUtil.readMultipleData("Multiple");
		return data;
		
	}
}



