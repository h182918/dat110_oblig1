package no.hvl.dat110.system.display;

import java.io.IOException;

import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		DisplayImpl display = new DisplayImpl();
		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);
		displayserver.register(1, display);
		
		try {
			displayserver.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		displayserver.stop();
		// TODO
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		
		System.out.println("Display server stopping ...");
		
	}
}
