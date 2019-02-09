package no.hvl.dat110.rpc.tests;

import java.io.IOException;

import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;

public class TestVoidVoidStub extends RPCStub {

	public void m() {
		
		byte[] request = RPCUtils.marshallVoid((byte)1);
		
		byte[] reply = null;
		try {
			reply = rmiclient.call(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RPCUtils.unmarshallVoid(reply);
		
	}
}
