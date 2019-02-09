package no.hvl.dat110.rpc;

import java.io.IOException;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		try {
			connection = msgclient.connect();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		
		if(connection != null) {
			connection.close();
		}
	}
	
	public byte[] call(byte[] rpcrequest) throws IOException {
		
		byte[] rpcreply;
		
		/* TODO: 
		
		Make a remote call on the RPC server by sending a request message
		and receive a reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpcreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		if(connection == null) {
			connect();
		}
		Message msg = new Message(rpcrequest);
		connection.send(msg);
		msg = connection.receive();
		rpcreply = msg.getData();
		return rpcreply;
	}
}
