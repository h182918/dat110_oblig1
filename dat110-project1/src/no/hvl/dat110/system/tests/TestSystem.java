package no.hvl.dat110.system.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import no.hvl.dat110.system.controller.Controller;
import no.hvl.dat110.system.display.DisplayDevice;
import no.hvl.dat110.system.sensor.SensorDevice;

class TestSystem {

	@Test
	void test() {

		System.out.println("System starting ...");

		Runnable display = () -> DisplayDevice.main(null);
		Runnable sensor = () -> SensorDevice.main(null);
		Runnable controller = () -> {
			try {
				Controller.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		};

		Thread displaythread = new Thread(display, "display");
		Thread sensorthread = new Thread(sensor, "sensor");
		Thread controllerthread = new Thread(controller, "controller");

		displaythread.start();
		sensorthread.start();
		controllerthread.start();
		
		try {
			displaythread.join();
			sensorthread.join();
			controllerthread.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// we check only termination here
		assertTrue(true);
			
		System.out.println("System stopping ...");
	}

}
