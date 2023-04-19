package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdate {

	public static void main(String[] args) throws Exception {//Driver for Mysql database
		Driver driverefer = new Driver();
		
		//step1: Register the Driver
		DriverManager.registerDriver(driverefer);
		
		//step2: Get the Connection from DataBase name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//step3: issue the crate statement
		Statement state = con.createStatement();
		
		//execute a query
		String query = "insert into candidateinfo values('Bannish',12,'KPHB');";
		int result = state.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("data added");	
		}
		ResultSet resul1 = state.executeQuery("select * from candidateinfo;");
		while(resul1.next())
		{
			System.out.println(resul1.getString(1)+" "+resul1.getInt(2)+" "+resul1.getString(3));			
		}
		//close the data
		con.close();
		System.out.println("db closed");
		}

}
