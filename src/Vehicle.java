
public abstract class Vehicle {
	
	int price, prodTime;
	String type;
	
	public void create() throws InterruptedException {
		System.out.format("Factory creates %s... \n", this.type);
		Thread.sleep(this.prodTime*100);
		System.out.format("Created %s in %d sec \n", this.type, this.prodTime);
	};
	
}
