package edu.name.javabasic;

import java.io.*;
import java.util.Scanner;

public class FileReader {
    public static void main(String [] args) throws IOException {
        File f = new File("Test.txt");
        Scanner scan = new Scanner(f);
        int count = 0;
        while (scan.hasNext()) {
        	scan.next();
        	count++;
        }
        System.out.println(count);
        scan.close();
    }    
}


