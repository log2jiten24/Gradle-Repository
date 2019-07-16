package ocrdemo;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Readpdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ITesseract image = new Tesseract();
		
		try {
			
		String str = image.doOCR(new File("C:\\Users\\ACER\\Desktop\\SBI_life_1Q488436204.pdf"));
		
		System.out.println ("Data captured from image :" + str );
	}

		catch (TesseractException e) {
			// TODO Auto-generated catch block
			System.out.println ("catched exception :" +e.getMessage());
		}

	}
}