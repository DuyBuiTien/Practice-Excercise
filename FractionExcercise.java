/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractorExercise;

import java.util.Scanner;

public class Fractor {
	//Mau so
	private int denominator;
	//Tu so
	private int numerator;
	
        Fractor(){
            this.denominator = 0;
            this.numerator = 0;
        }
	Fractor(int de, int num){
            this.denominator = de;
            this.numerator = num;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int findLeastCommonMultiple(int a, int b) {
		int max, step;
		
		if( a > b) {
			max = a;
			step = a;
		}
		else {
			max = b;
			step = b;
		}
		
		while(true) {
			if( max % a == 0 && max % b == 0 ) {
				return max;
			}
			max += step;
		}
	}
	
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
	
	public Fractor addFractor(int num1, int de1) {
		Fractor arrFractor = new Fractor(0, 0);
                int de = 0;
                int num = 0;
		if( de1 == this.getDenominator()) {
			de = num1 + this.getNumerator();
			num = de1;
		}
		else {
			int generalDenominator = findLeastCommonMultiple(de1, this.getDenominator());
			de = (generalDenominator/de1)*num1 
					+ (generalDenominator/this.getDenominator())*this.getNumerator();
			num = generalDenominator;
		}
		
                arrFractor.setDenominator(de);
                arrFractor.setNumerator(num);
		return arrFractor;
	}
	
            public int[] substractionFractor(int num1, int de1) {
		int[] arrFractor = new int[2];
		if( de1 == this.getDenominator()) {
			arrFractor[0] = Math.abs(num1 - this.getNumerator());
			arrFractor[1] = de1;
		}
		else {
			int generalDenominator = findLeastCommonMultiple(de1, this.getDenominator());
			arrFractor[0] = Math.abs((generalDenominator/de1)*num1 
					- (generalDenominator/this.getDenominator())*this.getNumerator());
			arrFractor[1] = generalDenominator;
		}
		
		return arrFractor;
            }
	
	    public int[] multiplicationFractor (int num1, int de1) {
		int[] arrFractor = new int[2];
		arrFractor[0] = num1*(this.getNumerator());
		arrFractor[1] = de1*(this.getDenominator());
		
		int generalFractor = greatestCommonDivision(arrFractor[0], arrFractor[1]);
		arrFractor[0] /= generalFractor;
		arrFractor[1] /= generalFractor;
		
		return arrFractor;
            }
            public int[] divisionFractor (int num1, int de1){
                return multiplicationFractor (de1, num1);
            }
            
            public boolean equals (Fractor f2){
                if(this.getDenominator() % f2.getDenominator() == 0
                    && this.getNumerator() % f2.getDenominator() == 0){
                    return true;
                }
                else{
                    return false;
                }
            }    
                
            	
	
}
		
