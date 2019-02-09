package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) throws IOException {
		rmiclient.connect();
		byte[] send = RPCUtils.marshallString(RPCID, message);
		RPCUtils.unmarshallVoid(rmiclient.call(send));
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
	}
}
