package no.hvl.dat110.rpc.tests;

import java.io.IOException;

import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;

public class TestIntIntStub extends RPCStub {

	private byte RPCID = 3;
	
	public int m(int x) {
				
		byte[] request = RPCUtils.marshallInteger(RPCID,x);
		
		byte[] reply = null;
		try {
			reply = rmiclient.call(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int xres = RPCUtils.unmarshallInteger(reply);
		
		return xres;
	}
}
