package vehicles;

public class Truck extends Vehicle {
	
	public Truck() throws InterruptedException {
		this.price = 2000;
		this.prodTime = 15; // in seconds
		this.type = "truck";
		this.create();
	}
}