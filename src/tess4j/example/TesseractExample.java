package tess4j.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.ImageHelper;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        File imageFile = new File("lib/Tess4J/20black.jpg");
        BufferedImage in = ImageIO.read(imageFile);
        ImageHelper.convertImageToGrayscale(in);
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