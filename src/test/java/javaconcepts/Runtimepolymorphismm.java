package javaconcepts;



class Reptiles  {
	
	public void move () {
	System.out.println("reptiles can move");	
	}
	
	public void eat () {
	System.out.println("reptiles  can eat ");	
	}
}

class Snake extends Reptiles {
	
	public void move (){
	System.out.println("snakes  can move");	
	     }
	
      }

class Lizard extends Reptiles {
	
	public void move () {
System.out.println("lizard can move");		
	}
	
}


public class Runtimepolymorphismm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//to call the object of the Reptile class
	    Reptiles rep = new Reptiles () ;
	    rep.move(); 
	    rep.eat();
	    
	    //to call the objects of the Snake class 
	    Snake sk = new Snake ();
	    sk.eat(); 
	    sk.move(); 
	    
	    //to call the objects of the lizard class   
	    Lizard liz = new Lizard () ;
	    liz.move(); 
	    liz.eat(); 
	    
	    //to achieve run time polymorphism
	    Reptiles obj = new Snake ();
	    obj.move();
	    //output = snakes can move 
	    //it called the subclass method instead of superclass method
	    
	    Reptiles obj1 = new Lizard ();
	    obj1.move(); 
	    obj1.eat();
	    //ouput = lizards can move 
	    //output = reptlies can eat 
	    
	    //it called the subclass method instead of superclass method 
	    //child class method is called 
	    
	    
	    
//	    When an overridden method is called through a reference of parent class, then type of the object determines which method is to be executed. 
//	    Thus, this determination is made at run time.
//	    Since both the classes, child class and parent class have the 
//	    same method animalSound. Which version of the method(child class or parent class)
//	    will be called is determined at runtime by JVM	

	}

}
