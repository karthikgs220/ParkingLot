package parkingSystem;

import java.util.*;

public class ParkingLot {
	private ArrayList<Car> spot = null;
	private int availableSpots;
	private int pos=0;
	public int getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
		spot = new ArrayList<Car>(availableSpots);
		System.out.println("Created a parking lot with " + availableSpots + " spots.");
	}
	
	public ArrayList<Car> getSpot() {
		return spot;
	}

	public boolean park(Car v) throws Exception {
			boolean add = false;
			if(pos < availableSpots) {
				if(spot.contains(v))
					throw new Exception("Car is already parked!!");
				for(int i=0;i<spot.size();i++) {
					if(spot.get(i) == null) {
				        spot.set(i, v);
						add = true;
						pos++;
						break;
					}	
				}
				if(!add) {
					spot.add(v);
					pos++;
				}
				
				System.out.println("Parking Car " + v.num + " In spot " + (spot.indexOf(v)+1));
				return true;
			}
			else
				return false;
	}
	
	public boolean leave(int p) {
		if(spot.get(p-1) != null) {
			spot.remove(p-1);
			pos--;
			spot.add(p-1, null);
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<Car> status() {
		ArrayList<Car> disp = spot;
		return disp;
	}
	
	public boolean registrationNumbersForCarsWithColour(String color) {
		boolean test=false;
		Car temp;
		System.out.println("List of Cars with "+color+ " color.");
		for(int i=0;i<spot.size();i++) { 	
			temp = spot.get(i);
			if(color.contentEquals(temp.color)) {
				test = true;
				System.out.println(temp.num);
			}
			
		}
		if(!test)			
			return false;
		else
			return true;
	}
	
	public boolean spotNumberForRegistrationNumber(String num) {
		Car temp;
		boolean test = false;
		System.out.println("Slot numbers of Cars with "+num+ " number.");
		for(int i=0;i<spot.size();i++) {
			temp = spot.get(i);
			if(num.contentEquals(temp.num)) {
				test = true;
				System.out.println(i+1);
			}				
		}
		if(!test) 
			return false;
		else
			return true;
	}
	
	public boolean spotNumbersForCarsWithColour(String color) {
		Car temp;
		boolean test = false;
		System.out.println("Slot Numbers of Cars with "+color+ " color.");
		for(int i=0;i<spot.size();i++) {
			temp = spot.get(i);
			if(color.contentEquals(temp.color)) {
				test = true;
				System.out.println(i+1);
			}	
		}
		if(!test) 
			return false;
		else
			return true;
	}
	
}
