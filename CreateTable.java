package southEasternDataAnalyticsPlatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
	
	public static void main(String arg[]) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/sedap";
		String username = "root";
		String password = "swati363";
		Connection connection = DriverManager.getConnection(url, username, password);;
		String sql="create table CustomerData(Entry_ID int,Customer_ID int,Customer_First_Name varchar(225),Customer_Last_Name varchar(225),Channel_Number int,Start_Watch_Time varchar(225),End_Watch_Time varchar(225),Customer_Age int)";
		connection.setAutoCommit(false);	
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.commit();
		statement.close();
		connection.close();
		
		System.out.println("Its Done");
		
	}

}


}
