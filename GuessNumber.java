package edu.name.javabasic;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String [] args) {
		Random rand = new Random(); 
		int genNumber = rand.nextInt(50); 
		
		System.out.println(genNumber);
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int guessNumber = scan.nextInt();
			if (guessNumber == genNumber) {
				System.out.println(" YOU WIN!!! ");
				break;
			} else {
				if (guessNumber > genNumber) {
					System.out.println(" Please try again. Your guessed number is larger than generate number");
				}
				if (guessNumber < genNumber) {
					System.out.println(" Please try again. Your guessed number is smaller than generate number");
				}
			}
		}
		
		
		scan.close();
	}
}
