package no.hvl.dat110.messaging.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessageConfig;
import no.hvl.dat110.messaging.MessagingClient;
import no.hvl.dat110.messaging.MessagingServer;

public class TestMessaging {

	@Test
	public void test() {

		byte[] clientsent = { 1, 2, 3, 4, 5 };

		Thread server = new Thread() {
	
			public void run() {

				System.out.println("Messaging server - start");
				
				MessagingServer server = new MessagingServer(MessageConfig.MESSAGINGPORT);

				Connection connection = null;
				try {
					connection = server.accept();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				Message request = null;
				try {
					request = connection.receive();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				byte[] serverreceived = request.getData();

				Message reply = new Message(serverreceived);

				try {
					connection.send(reply);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				connection.close();

				server.stop();

				System.out.println("Messaging server - stop");

				assertTrue(Arrays.equals(clientsent, serverreceived));


			}
		};

		Thread client = new Thread() {
			
			public void run() {

				System.out.println("Messaging client - start");

				MessagingClient client = 
						new MessagingClient(MessageConfig.MESSAGINGHOST, MessageConfig.MESSAGINGPORT);

				Connection connection = null;
				try {
					connection = client.connect();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Message message1 = new Message(clientsent);

				try {
					connection.send(message1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Message message2 = null;
				try {
					message2 = connection.receive();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    byte[] clientreceived = message2.getData();

				connection.close();

				System.out.println("Messaging client - stop");

				assertTrue(Arrays.equals(clientsent, clientreceived));
			}

		};

		server.start();
		client.start();

		try {
			server.join();
			client.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
