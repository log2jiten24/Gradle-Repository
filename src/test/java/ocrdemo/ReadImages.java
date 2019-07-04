package ocrdemo;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages {

	public static void main(String[] args) {
	
	ITesseract image = new Tesseract();
		
		try {
			
		String str = image.doOCR(new File("C:\\Users\\ACER\\Desktop\\thoughts01.png"));
		
		System.out.println ("Data captured from image :" + str );
		
		String []mydata = str.split(";");
		
		System.out.println ("array data : "+ mydata[1]);
		
		String dataupd = mydata[1].replaceAll("‘", "23");
		System.out.println ("updtd string :"+ dataupd);
		
		//replace the string
		String updtstr = dataupd.replaceAll("[a-z A-Z]", " ");
		
		System.out.println("regular expression :" + updtstr) ;
		
		//regular expression : 
		//it will replace all the characters as blank
		
        String updtstring = dataupd.replaceAll("[^a-z A-Z]", " ");
		
		System.out.println("regular expression :" + updtstring) ;
		
		
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			System.out.println ("catched exception :" +e.getMessage());
		}

	}

}
