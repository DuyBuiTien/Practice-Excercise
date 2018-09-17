package edu.name.javabasic;

public class FractionExcercise {
	//Mau so
	private int denominator;
	
	//Tu so
	private int numerator;
	
	FractionExcercise(int de, int num){
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
		int lcm = 0;
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
	
	public int[] addFractor(int num1, int de1) {
		int[] arrFractor = new int[2];
		if( de1 == this.getDenominator()) {
			arrFractor[0] = num1 + this.getNumerator();
			arrFractor[1] = de1;
		}
		else {
			int generalDenominator = findLeastCommonMultiple(de1, this.getDenominator());
			arrFractor[0] = (generalDenominator/de1)*num1 
					+ (generalDenominator/this.getDenominator())*this.getNumerator();
			arrFractor[1] = generalDenominator;
		}
		
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
	
	public int[] multiplicationFractor(int num1, int de1) {
		int[] arrFractor = new int[2];
		arrFractor[0] = num1*(this.getNumerator());
		arrFractor[1] = de1*(this.getDenominator());
		
		int generalFractor = greatestCommonDivision(arrFractor[0], arrFractor[1]);
		arrFractor[0] /= generalFractor;
		arrFractor[1] /= generalFractor;
		
		return arrFractor;
	}
	
	public int[] divisionFractor(int num1, int de1) {
		int[] arrFractor = new int[2];
		arrFractor[0] = num1*(this.getNumerator());
		arrFractor[1] = de1*(this.getDenominator());
		
		int generalFractor = greatestCommonDivision(arrFractor[0], arrFractor[1]);
		arrFractor[0] /= generalFractor;
		arrFractor[1] /= generalFractor;
		
		return arrFractor;
	}
	private void static main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
