package Practice;

import vitiger.GenericUtilites.JavaUtility;

public class PrintDateDefault {
	public static void main(String[] args) {
		
	
	JavaUtility jUtil = new JavaUtility();
	String s = jUtil.getSystemDate();
	System.out.println(s);
	String d =jUtil.getSystemDateInFormat();
	System.out.println(d);

}
}