package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 2;
	
	public int read() throws IOException {
		
		int temp;
		
		rmiclient.connect();
		byte[] send =  RPCUtils.marshallInteger(RPCID, 0);
		byte[] received = rmiclient.call(send);
		temp = RPCUtils.unmarshallInteger(received);

		return temp;
	}
	
}
