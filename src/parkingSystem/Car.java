package parkingSystem;

public class Car extends Vehicle{
	public Car(String v, String c) {
		super(v, c);
	}
	@Override
	public String toString() {
		return "\t" + num +  "\t\t\t" + color;
	}
	
}
