package southEasternDataAnalyticsPlatform;

import java.io.IOException;
import java.sql.SQLException;



public class StartSEDAP {

	public static void main(String[] args) throws SQLException {

		FileReading fr = null;
		try {
			fr = new FileReading();
			ValidationAndLoadCustomerData validate = new ValidationAndLoadCustomerData();
			while (fr.hasNext()) {
				fr.readingText();
				validate.insertRecords(fr);
			}

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}

