package Practice;

import java.io.IOException;

//import GenricUtilities.PropertiFileUtility;
import vitiger.GenericUtilites.ExcelFileUtility;
import vitiger.GenericUtilites.JavaUtility;
//import vitiger.GenericUtilites.PrpertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception {
		/*PrpertyFileUtility putil = new PrpertyFileUtility();
		String URL = putil.readDataFromPropertyFile("username");
		System.out.println(URL);*/
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("contacts", 4, 2);
		System.out.println(value);
		
		System.out.println(eUtil.getRowCount("contacts"));
		eUtil.writeDataIntoExcel("contacts", 2, 1, "mama Nuv Thopu ra");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());

	}

}
