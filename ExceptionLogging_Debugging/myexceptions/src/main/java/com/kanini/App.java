package com.kanini;
import java.util.List;

public class App {
    public static void main(String[] args) {

        FileReader reader = new FileReader();

        try {
            List<Users> user = reader.readCsv("S:\\Kanini\\KA-2025 Training\\JAVA\\TrainingModules\\Module3\\data.csv"); 
System.out.println("ID | Name | Age");
            for (Users p : user) {
                System.out.println(p);
            }

        } catch (FileException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }
}
