package southEasternDataAnalyticsPlatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ValidationAndLoadCustomerData {

	String url = "jdbc:mysql://localhost:3306/sedap";
	String username = "root";
	String password = "swati363";

	String sql = "INSERT INTO CustomerData (Entry_ID, Customer_ID, Customer_First_Name, Customer_Last_Name, Channel_Number,Start_Watch_Time,End_Watch_Time,Customer_Age) VALUES (?, ?, ?, ?, ?,?,?,?)";

	PreparedStatement statement = null;

	int count = 0;
	int batchSize = 100;

	public void insertRecords(FileReading fr) {

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			statement = connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			statement.setInt(1, Integer.parseInt(fr.entry_ID.trim()));
			statement.setInt(2, Integer.parseInt(fr.customer_ID.trim()));
			statement.setString(3, fr.customer_First_Name.trim());
			statement.setString(4, fr.customer_Last_Name.trim());
			statement.setInt(5, Integer.parseInt(fr.channel_Number.trim()));
			statement.setString(6, fr.start_Watch_Time.trim());
			statement.setString(7, fr.end_Watch_Time.trim());
			int age = Integer.parseInt(fr.customer_Age.trim());

			while (age >= 10) {

				statement.setInt(8, age);
				statement.addBatch();

				count++;
				if (count % batchSize == 0) {
					statement.executeBatch();

				}
			}
			statement.executeBatch();
			connection.commit();
			statement.close();
			connection.close();
			System.out.println("Its Done");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}

