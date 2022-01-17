package SEDAP.ActiveMQMessaging;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SEDAPMessaging {
	static String lineText = null;
	public static void main(String[] args) throws Exception {

		try {
			ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection con = cf.createConnection();
			con.start();
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\Swati Kumar\\Desktop\\test.com\\Customer.csv"));
			while ((lineText=br.readLine()) != null) {
				
				String[] data = lineText.split(",");
				String customer_Age = data[7];
				int age = Integer.parseInt(customer_Age);

				if (age <= 18) {
					Destination destination = session.createQueue("SEDAP");
					MessageProducer producer = session.createProducer(destination);
					Message message = session.createTextMessage("This is an invalid record/Age smaller than 18 years,the age is "+age+ " years");
					producer.send(message);
				}
			}
br.close();
			System.out.println("This is done!!");

		} catch (JMSException jex) {
			// TODO Auto-generated catch block
			jex.printStackTrace();
		}

	}

}
