package Vitiger.Contacts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vitiger.GenericUtilites.BaseClass;
import vitiger.ObjectRepository.ContactsInfoPage;
import vitiger.ObjectRepository.ContactsPage;
import vitiger.ObjectRepository.CreateNewContactPage;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrganizationTest() throws Exception {
		
		/*Read data from excel sheet - Test data*/
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//step4: click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		Reporter.log("click on Organization Link Successful");
		
		//step5: click on create Organization lookup img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create Organization lookup img successful");
		
		//step 7: create Organization with mandatory details
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("create Organization with mandatory details Successful"); 
	
		//step8: validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader+"--organization created--");
		
		//step9: Navigate to contacts Link
		hp.clickOnContactsLnk();
		Reporter.log("Navigate to contacts Link successful");
		
		//step10: Click on create contact lookup img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Click on create contact lookup img Successful");
		//Assert.fail();
		
		//step11: Create contact with mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Create contact with mandatory fields and save Successful");
		
		//step 12: validate for contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHrader();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+"--contact created--");
		
	}
}
