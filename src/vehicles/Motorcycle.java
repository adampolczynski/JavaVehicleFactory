package vehicles;

public class Motorcycle extends Vehicle {
	
	public Motorcycle() throws InterruptedException {
		this.price = 600;
		this.prodTime = 5; // in seconds
		this.type = "motorcycle";
		this.create();
	}
}