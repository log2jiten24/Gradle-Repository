package Inheritanceconcept;

public class Childclass extends Parentclass {

	public Childclass() {
		
		//ctrl +shift+S = for proper formatting

		// super keyword - it is used to call the parent class constructor
		// super keyoword - is called then the default constructor doesn't gets called
		// super keyword - it should be first statement inside the constructor
		// super keyowrd - it will have only one super keyword ,inside a single
		// constructor we can have only one super keyowrd
		// in a single constructor we cannot have two super keywords
		// super - if super keyword is having no parameter - it will call the parent
		// class constructor
		// super (10);
		super(10, 60);

		// using the super. - keyowrd in the constructor itself we can call the parent
		// class methods inside the constructor
		super.start();
		System.out.println("child class constructor ");
	}

	// once the parent class method is made as final - child class method will show
	// error ,as final methods cannot be overridden
//	public void start () {
//	
//	System.out.println ("Child class start ");	
//	}

	public void startinitial() {

		System.out.println("child class start ");
	}

	// method with parameters different from parent class
	public void calculate(double a, int b) {
		double c = a + b;
		System.out.println("sum is from child  class " + c);
	}

	// method with same parameters from parent class
	public void multiply(int a, int b) {
		int c = a * b;
		System.out.println("multiply from child class " + c);

	}

	public static void main(String[] args) {

		Childclass obj = new Childclass();

		Parentclass obj3 = new Childclass();
		// output = value of i is 10
		// output - child class constructor

		// constructor calling - first the parent class constructor gets called followed
		// by the child class constructor
		// if the child class is extending the parent class constructor . (if the parent
		// class constructor is having no constructor ,
		// then also parent class constructor gets called .

		// child class method will get execute
		// obj.start();
		// it will also show parent class methods as child class have inherited parent
		// class methods

		// it will execute parent class methods as start method is not overridden with
		// child class
		obj.start();

		// it will execute child class method
		obj.startinitial();

		// to check the method with parameters
		// if the method name is not having same datatype parameter or different
		// parameters -method cannot be overridden
		obj.calculate(3, 3);

		// child classs method will get called
		obj.calculate(3.5, 4);

		// method will get override as parent class and child class method signature is
		// the same
		obj.multiply(4, 8);

		Parentclass obj1 = new Childclass();

		// run time polymorphism - child class method will get preference over the
		// parent class method
		// obj1.start();

		// it will execute the child class method ,but while typing with obj1 its
		// showing the parent class
		// method but it will execute the child class method .
		obj1.startinitial();

		// it will execute parent class methods as start method is not overridden with
		// child class
		obj1.start();

		// it will only show parent class method
		obj1.calculate(4, 9);

		// method will get override as parent class and child class method signature is
		// the same
		// child class method will get executed
		obj1.multiply(4, 100);
	}

}
