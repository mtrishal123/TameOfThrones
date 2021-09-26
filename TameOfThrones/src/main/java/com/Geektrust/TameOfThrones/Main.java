package com.Geektrust.TameOfThrones;



import static com.Geektrust.TameOfThrones.services.FileProcessor.processFile;

public class Main {

    public static void main(String args[]) {
        String filename = "src/main/resources/input.txt";
        processFile(filename);

    }
}
