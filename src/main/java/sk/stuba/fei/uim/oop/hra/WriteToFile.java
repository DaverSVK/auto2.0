package sk.stuba.fei.uim.oop.hra;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

    PrintWriter outputStream;
    public WriteToFile(ArrayList<Double> suradnicaX, ArrayList<Double> suradnicaY, ArrayList<Double> uholVT) {

        try {

            outputStream = new PrintWriter("hodnoty.csv");

            StringBuilder WTF = new StringBuilder();
            for (Double x : suradnicaX) {
                WTF.append(x);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Double integer : suradnicaY) {
                WTF.append(integer);
                WTF.append(',');
            }
            WTF.append('\n');
            for (Double aDouble : uholVT) {
                WTF.append(aDouble);
                WTF.append(',');
            }
            WTF.append('\n');
            System.out.print(WTF);
            outputStream.write(WTF.toString());
            outputStream.close();


            System.out.print("File is created successfully with the content.");
        }


        catch (IOException e) {

            System.out.print(e.getMessage());
        }

    }
}
