package Javapractice;


//add all the unimplemented methods of the interface and write the body of the methods 
public class BMWCar implements Car {

	@Override
	public void start() {
	
	System.out.println ("BMW car --start ");
		
	}

	@Override
	public void stop() {
	
    System.out.println ("BMW car --stop ");	
		
	}

	@Override
	public void refuel() {
	
	System.out.println ("BMW car --refuel ");	
			
	}

	
	//non overridden methods 
	
	public void BMWSafety () {
	
	System.out.println ("BMW Safety method ");	
	}
	
	//overridden methods 
	public  void cartype () {
	System.out.println ("BMW Car Type ");	
	}
}
