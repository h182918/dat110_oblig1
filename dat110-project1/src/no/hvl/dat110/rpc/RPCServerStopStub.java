package no.hvl.dat110.rpc;

import java.io.IOException;

public class RPCServerStopStub extends RPCStub {

	// client-side implementation of the built-in server stop RPC method
	public void stop () {
		
		byte[] request = RPCUtils.marshallVoid(RPCCommon.RPIDSTOP);
		
		byte[] response = null;
		try {
			response = rmiclient.call(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RPCUtils.unmarshallVoid(response);
	
	}
}
