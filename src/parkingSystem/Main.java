package parkingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner myObj = new Scanner(System.in);
		ArrayList<Car> ve = null;
		System.out.println("Enter the number of parking spots required: ");
		int numSpots = myObj.nextInt();
		ve = new ArrayList<Car>(numSpots);
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(numSpots);			//Setting the maximum number of available slots in the parking lot
		while(true)
		{
			System.out.println("-----Usage-----");
			System.out.println("1.Enter Car Details");
			System.out.println("2.Park a Car");
			System.out.println("3.Remove a Car");
			System.out.println("4.Display Status");
			System.out.println("5.Display Reg Num of Car by entering Color");
			System.out.println("6.Display Slot Number of car by entering color");
			System.out.println("7.Display Slot number of Car by entering Reg Number");
			System.out.println("8.Display Registered Cars");
			System.out.println("9.Exit");
			int opt = myObj.nextInt();
		
			switch(opt) {												//Using a Switch case to run the right operation
			case 1: System.out.println("Enter Car Number");
					String numb = myObj.next();
					for(int z=0;z<ve.size();z++) {
						Car t = ve.get(z);
						if(numb.contentEquals(t.num)) 		//Checking if the car is already registered
							throw new Exception("Car Already Exists!");		
					}
					System.out.println("Enter Car Color:");
					String col = myObj.next();
					ve.add(new Car(numb,col));
					System.out.println("Car Registered Successfully.");
					break;
			case 2: System.out.println("Enter Car Number to be parked: ");
					String num = myObj.next();
					boolean parked = false;
					boolean test=false;
					for(int i=0;i<ve.size();i++) {
						Car t=ve.get(i);
						if(num.contentEquals(t.num)) {
							test=true;
							parked = p.park(t);		//calling park function to park the car and return true or false
						}
					}
					if(test && parked)						
						System.out.println("Car Parked!");
					else if(!test)
						System.out.println("Car not registered, please register first!");
					else if(!parked)
						throw new Exception("Parking lot is full");
					break;
			case 3: System.out.println("Enter Slot Number to be emptied: ");
					boolean left = false;
					int num1 = myObj.nextInt();
					left = p.leave(num1);		//calling leave method to remove the car at num1 spot
					if(!left)
						throw new Exception("Slot " + num1+" is empty");
					else 
						System.out.println("Slot number " + num1 + " is now free");
					break;
			case 4: ArrayList<Car> t = p.status();  //calling the status method to return the Arraylist of elements to be displayed
					System.out.println("Slot no.\tRegistration No.	Color");
					for(int i=0; i<t.size();i++) {
						if(t.get(i)!=null)
							System.out.println(i+1 + "\t" + t.get(i));
					}
					break;
			case 5: System.out.println("Enter Color of the car to be searched: ");
					String color = myObj.next();
					boolean ret = p.registrationNumbersForCarsWithColour(color); //passing the color of the cars whose reg no is to be displayed
					if(!ret)
						System.out.println("The car with " + color + " color is not parked");
					break;
			case 6: System.out.println("Enter Color of the car to be searched: ");
					String color1 = myObj.next();
					boolean ret1 = p.spotNumbersForCarsWithColour(color1);
					if(!ret1)
						System.out.println("The car with " + color1 + " color is not parked");
					break;
			case 7: System.out.println("Enter Registration Number of the car to be searched: ");
					String reg = myObj.next();
					boolean ret2 = p.spotNumberForRegistrationNumber(reg);  //passing the reg no of the cars whose spot no is to be displayed
					if(!ret2)
						System.out.println("The Car number " + reg + " is not parked");
					break;
			case 8: System.out.println("Registered Cars are: ");
					System.out.println("Slot no.\tRegistration No.");
					for(int i=0; i<ve.size();i++) {
						Car v = ve.get(i);
						System.out.println(i+1 + "\t\t\t" + v.num);   //code to display all registered cars
					}
					break;
			case 9: myObj.close();
					System.exit(0);
			default: System.out.println("Invalid Input!");
			 		 break;
			}
		
		}
	}
}
