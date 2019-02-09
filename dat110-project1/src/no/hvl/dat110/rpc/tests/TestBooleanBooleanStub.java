package no.hvl.dat110.rpc.tests;

import java.io.IOException;

import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;

public class TestBooleanBooleanStub extends RPCStub {

	private byte RPCID = 4;
	
	public boolean m(boolean b) {
		
		byte[] request = RPCUtils.marshallBoolean(RPCID,b);
		
		byte[] reply = null;
		try {
			reply = rmiclient.call(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean bres = RPCUtils.unmarshallBoolean(reply);
		
		return bres;
	}
	
}
