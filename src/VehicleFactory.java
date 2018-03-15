import java.io.FileInputStream;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class VehicleFactory {
	
	public static void main(String[] args) throws InterruptedException {
		readLine();
	}
	
	private static void readLine() {
		System.out.println("Please give a XML file path: ");
		Scanner scanner = new Scanner(System.in);
		readXML(scanner.nextLine());
	}
	
	private static void readXML(String XMLPath) {
		try (FileInputStream fis = new FileInputStream(XMLPath)) {
	        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
	        XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
	        while(reader.hasNext()) {
	        	int eventType = reader.next();
	        	  switch (eventType) {
	        	    case XMLStreamReader.START_ELEMENT:
	        	      // handle start element

	        	    case XMLStreamReader.ATTRIBUTE:
	        	      // handle attribute
	        	    	if (reader.getName().toString().equals("item")) {
	        	    		System.out.println("---------"+reader.getAttributeValue(0));
		    	        	createNewVehicle(reader.getAttributeValue(0));
	        	    	}

	        	  }
	        }
	    } catch (Exception e) {
	    	System.err.println(e);
	    	System.out.println("Try again...");
	    	readLine();
	    }
	}
	private static boolean createNewVehicle(String what) throws InterruptedException {
		
		boolean flag = false;
		
		switch (what) {
			case "car":
				new Car();
				flag = true;
				break;
			case "truck":
				new Truck();
				flag = true;
				break;
			case "motorcycle":
				new Motorcycle();
				flag = true;
				break;
		}
		
		return flag;
		
	}
}

class Car extends Vehicle {
	
	public Car() throws InterruptedException {
		this.price = 1000;
		this.prodTime = 10; // in seconds
		this.type = "car";
		this.create();
	}
}
class Motorcycle extends Vehicle {
	
	Motorcycle() throws InterruptedException {
		this.price = 600;
		this.prodTime = 5; // in seconds
		this.type = "motorcycle";
		this.create();
	}
}
class Truck extends Vehicle {
	
	Truck() throws InterruptedException {
		this.price = 2000;
		this.prodTime = 15; // in seconds
		this.type = "truck";
		this.create();
	}
	
}
