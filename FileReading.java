package southEasternDataAnalyticsPlatform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {

	static String lineText;
	static String[] data;

	String entry_ID;
	String customer_ID;
	String customer_First_Name;
	String customer_Last_Name;
	String channel_Number;
	String start_Watch_Time;
	String end_Watch_Time;
	String customer_Age;
	BufferedReader lineReader = null;

	public FileReading() throws IOException {
		lineReader = new BufferedReader(new FileReader("C:\\Users\\Swati Kumar\\Desktop\\test.com\\Customer.csv"));
		lineReader.readLine();
	}

	public void readingText() throws IOException {

		data = lineText.split(",");
		entry_ID = data[0];
		customer_ID = data[1];
		customer_First_Name = data[2];
		customer_Last_Name = data[3];
		channel_Number = data[4];
		start_Watch_Time = data[5];
		end_Watch_Time = data[6];
		customer_Age = data[7];

	}

	public boolean hasNext() throws IOException {
		lineText = lineReader.readLine();
		return null != lineText;
	}

}
