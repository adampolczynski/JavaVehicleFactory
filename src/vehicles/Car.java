package vehicles;

public class Car extends Vehicle {
	public Car() throws InterruptedException {
		this.price = 1000;
		this.prodTime = 10; // in seconds
		this.type = "car";
		this.create();
	}
}
