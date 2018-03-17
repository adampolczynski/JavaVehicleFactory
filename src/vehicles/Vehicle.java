package vehicles;

public abstract class Vehicle {
	
	public int price;
	protected int prodTime;
	protected String type;
	
	public void create() throws InterruptedException {
		System.out.format("Factory creates %s... \n", this.type);
		Thread.sleep(this.prodTime*100);
		System.out.format("Created %s in %d sec \n", this.type, this.prodTime);
	};
	
}
