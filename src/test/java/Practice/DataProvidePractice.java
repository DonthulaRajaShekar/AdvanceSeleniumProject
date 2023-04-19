package Practice;
import org.testng.annotations.DataProvider;
//data mapping
import org.testng.annotations.Test;

public class DataProvidePractice {
	
	@Test(dataProvider = "electronics")//output depends on dataProvider
	public void addProduct(String Phone)
	{
		System.out.println(Phone);
	}
	
	@DataProvider(name="Phone")
	public Object[][] getData()  
	{							//row //column
		Object[][] data = new Object[3][2];//3set of data each consists of 2 info
		
		data[0][0] = "Samsung";
		data[0][1] = 12000;
		
		data[1][0] = "Iphone";
		data[1][1] = 10000;
		
		data[2][0] = "Nokia";
		data[2][1] = 11000;
		
		return data;
	}
	@DataProvider(name = "electronics")
	public Object[][] getData1()
	{
		Object[][] data = new Object[3][1];//3 set of data each consists of 1 info
		//4 //3
		data[0][0] = "samsung13x";
		
		data[1][0] = "Iphone11";
		
		data[2][0] = "NokiaOld";
		
		return data;
	}
	
	
}
