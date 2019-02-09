package no.hvl.dat110.rpc.tests;

import java.io.IOException;

import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;

public class TestStringStringStub extends RPCStub {

	public String m(String str) {
		
		byte[] request = RPCUtils.marshallString((byte)2,str);
		
		byte[] reply = null;
		try {
			reply = rmiclient.call(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strres = RPCUtils.unmarshallString(reply);
		
		return strres;
	}
}
