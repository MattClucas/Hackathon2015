package tess4j.example;

import java.io.File;
import net.sourceforge.tess4j.*;

public class TesseractExample {

    public static void main(String[] args) {
        File imageFile = new File("lib/Tess4J/bleh.png");
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        instance.setDatapath("lib/Tess4J");
        instance.setLanguage("eng");
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}