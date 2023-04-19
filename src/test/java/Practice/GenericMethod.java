package Practice;

public class GenericMethod {

	public static void main(String[] args) {//caller function
		int sum = add(30,52);
		System.out.println(sum);

	}
	public static int add(int a,int b)	// called function
	{
		int c=a+b;
		return c;
	}

}//it has specific return type and parametrsie only this can be chanable
// Generic method is a first step in frame work develop
