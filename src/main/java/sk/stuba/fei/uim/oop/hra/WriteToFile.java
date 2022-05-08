package sk.stuba.fei.uim.oop.hra;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

    PrintWriter outputStream;
    public WriteToFile(ArrayList<Integer> suradnicaX, ArrayList<Integer> suradnicaY,ArrayList<Integer> suradnicaX1,ArrayList<Integer> suradnicaX2,ArrayList<Integer> suradnicaY1,ArrayList<Integer> suradnicaY2, ArrayList<Double> uholVT) {

        try {

            // Step 1:  Create an object of FileOutputStream
            outputStream = new PrintWriter("hodnoty.csv");

            // Step 2: Store byte content from string
            StringBuilder WTF = new StringBuilder();
            for (Integer x : suradnicaX) {
                WTF.append(x);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Integer integer : suradnicaY) {
                WTF.append(integer);
                WTF.append(',');
            }
            WTF.append('\n');/*
            for (Integer x1 : suradnicaX1) {
                WTF.append(x1);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Integer integer1 : suradnicaY1) {
                WTF.append(integer1);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Integer x2 : suradnicaX2) {
                WTF.append(x2);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Integer integer2 : suradnicaY2) {
                WTF.append(integer2);
                WTF.append(',');
            }*/
            WTF.append('\n');
            for (Double aDouble : uholVT) {
                WTF.append(aDouble);
                WTF.append(',');
            }
            WTF.append('\n');
            System.out.print(WTF);
            // Step 3: Write into the file
            outputStream.write(WTF.toString());
            outputStream.close();

            // Print the success message (Optional)
            System.out.print("File is created successfully with the content.");
        }

        // Catch block to handle the exception
        catch (IOException e) {

            // Display the exception/s
            System.out.print(e.getMessage());
        }

    }
}
