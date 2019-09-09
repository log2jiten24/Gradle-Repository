package Inheritanceconcept;

public class Finalizeconcept {
	
	//finalize is the method 
	
	public void finalize () {
		System.out.println ("finalize method ");
	}

	public static void main(String[] args) {
	
	Finalizeconcept f1 = new Finalizeconcept()	;
	
	Finalizeconcept f2 = new Finalizeconcept() ;
	
	f1 = null ;//both f1 and f2 is having null reference in the memory 
	
	f2 = null ;
	
	//functions of garbage collector - it will destroy all the objects for which reference is null
	//or the objects which are not in use or taking lots of memory --to free some memory (to perform clanup.)
	
	//garbage collector method 
	//finalize method is used call before the garbage collector to just cleanup the objects 
	System.gc();
	

	}

}
