package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SamoleJDBCExecuteQuey {

	public static void main(String[] args) throws Exception {
		//Driver for Mysql database
		Driver driverefer = new Driver();
		
		//step1: Register the Driver
		DriverManager.registerDriver(driverefer);
		
		//step2: Get the Connection from DataBase name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//step3: issue the crate statement
		Statement state = con.createStatement();
		
		//step4: execute a query table name
		ResultSet result = state.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			
		}
		
		//step5: close the DataBase
		con.close(); 
		System.out.println("DB closed successfully");
	}

}
