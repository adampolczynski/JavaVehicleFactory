import java.util.concurrent.Callable;

import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Truck;
import vehicles.Vehicle;

public class FactoryWorker implements Callable<Integer> {
    
	String vehicleType;
 
    FactoryWorker(String type) {
    	this.vehicleType = type;
    }
 
    public Integer call() throws InterruptedException {
        
        return createNewVehicle(vehicleType);
    }
    
    private static int createNewVehicle(String type) throws InterruptedException {
		
    	Vehicle vehicle;
    	int price = 0;
    	
		switch (type) {
			case "car":
				vehicle = new Car();
				break;
			case "truck":
				vehicle = new Truck();
				break;
			case "motorcycle":
				vehicle = new Motorcycle();
				break;
			default:
				vehicle = null; // look below
				break;
		}
		
		if (vehicle == null) { 
			price = 0; 
			// actually good solution because price = 0 and there is no feedback also
		} else {
			price = vehicle.price;
		}
		
		return price;
		
	}

}