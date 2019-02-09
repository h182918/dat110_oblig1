package no.hvl.dat110.rpc;

import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {
		byte[] strBytes = null;
		byte[] encoded = null;
		if(str != null) {
			strBytes = str.getBytes();
			encoded = new byte[strBytes.length + 1];
			encoded[0] = rpcid;
			for(int i = 0; i <strBytes.length; i++) {
				encoded[i + 1] = strBytes[i];
			}
		}
		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;
		byte[] dec = new byte[data.length - 1];

		for(int i = 1; i < data.length; i++) {
			dec[i - 1] = data[i];
		}
		decoded = new String(dec); 
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// trenger ikke gjøre noe
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {
		return (data[1] > 0);
	}

	public static byte[] marshallInteger(byte rpcid, int x) {
		Integer number = x;
		String param = number.toString();
		byte[] strBytes = param.getBytes();
		byte[] encoded = new byte[strBytes.length + 1];
		encoded[0] = rpcid;
		for(int i = 0; i < strBytes.length; i++) {
			encoded[i + 1] = strBytes[i];
		}
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		String decAsString = unmarshallString(data);
		int decoded = Integer.parseInt(decAsString);
		return decoded;
	}
}
