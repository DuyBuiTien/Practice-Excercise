package edu.name.javabasic;


import java.util.*;




public class GreatestCommonDivision {

    // Complete the hourglassSum function below.
    public static int greatestCommonDivision(int a, int b) {
    	if( a == 1 || b == 1) {
    		return 1;
    	}
    	
    	else {
    		while( a != b ) {
    			if( a > b ) {
    				a = a - b;
    			}
    			else {
    				b = b -a;
    			}
    		}
    		return a;
    	}
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int a = scan.nextInt();
    	int b = scan.nextInt();
    	scan.close();
    	
    	int gcd = greatestCommonDivision(a, b);
    	System.out.println(gcd);
    }
    
}