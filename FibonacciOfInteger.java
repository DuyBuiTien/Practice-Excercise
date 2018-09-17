package edu.name.javabasic;

import java.util.Scanner;

public class FibonacciOfInteger {
	public static int sumFibonacci(int n) {
		
		if( n >= 0 ) {	
			if( n == 0 ) {
				return 0;
			}
			else if( n == 1 ) {
				return 1;
			}
			else if( n == 2) {
				return 1;
			}
			else {
				return sumFibonacci( n - 1 ) + sumFibonacci( n - 2 );
			}	
		}
		
		else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		int sum = sumFibonacci(n);
		if( sum == -1 ) {
			System.out.println("Invalid number. Please try again.");
		}
		else {
			System.out.println(sum);
		}
	}
}
