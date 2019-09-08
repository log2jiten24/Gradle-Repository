package Javapractice;

public class Testcar {

	public static void main(String[] args) {
		
		
		BMWCar c1 = new BMWCar() ;
		//it will access all the methods of the BMWCar class 
		c1.start();
		c1.stop();
		c1.refuel();
		//non overridden method 
		c1.BMWSafety();
		
		//overridden methods -- child class method body will be executed (run time polymorphism)
		c1.cartype();
		
		//run time polymorphism (typecasting-dynamic polymorphism ) 
		
		Car c2 = new BMWCar() ;
		//Child class method can be accessed by parent class abstract/interface class variable 
		c2.refuel();
		c2.start();
		c2.stop();
		//overridden methods -- child class method body will be executed (run time polymorphism)
		//both the parent class and child class having the same method name with the body,always child 
		//class method get the precedence over the parent class 
		c2.cartype();
        //BMWSafety method can't be accessed here 
        
		//to access the static method of the interface 
        Car.cartyre();
	}

}
