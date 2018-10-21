package edu.ex.dictionary;

import java.util.*;
import java.io.*;

/*
 * 
 * Author : BuiTienDuy
 * Date   : 09/27/2018
 * 
 * 
*/

	

public class Dictionary_English_Vietnamese {
	
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			Dictionary dic = new Dictionary();
			File file = new File("dictionary.txt");
			String str = "";
			String temp = "";
			DictionaryCommandLine dicCMD = new DictionaryCommandLine();
			System.out.print("Type in your searching word : ");
			while (!(temp = scan.nextLine()).isEmpty()){
	            str = temp;
	        }
			dicCMD.dictionaryAdvanced(dic, file, str);
	    } finally {
	        if (scan != null)
	        	scan.close();
	    }
		
		
	}
	
}

class Word{
	
	private String word_target;
	private String word_explain;
	
	
	public String getWord_explain() {
		return word_explain;
	}


	public void setWord_explain(String word_explain) {
		this.word_explain = word_explain;
	}


	public String getWord_target() {
		return word_target;
	}


	public void setWord_target(String word_target) {
		this.word_target = word_target;
	}


	public Word(String t, String e) {
		this.word_target = t;
		this.word_explain = e;
	}


	public Word() {
		// TODO Auto-generated constructor stub
	}
}

class Dictionary{
	
	static ArrayList<Word> list = new ArrayList<>();
	
}

class DictionaryManagement{
	
	private static final Scanner scan = new Scanner(System.in);
	
	public void insertFromCommandLine (int n) {
		
		for (int i = 0; i < n; i++) {
			Word word = new Word();
			word.setWord_explain(scan.next());
			if (word.getWord_explain().contains("-")) {
				String [] part = word.getWord_explain().split("-");
				word.setWord_explain(part[0] + " " + part[1]);
			}
			word.setWord_target(scan.next());
			if (word.getWord_target().contains("-")) {
				String [] part = word.getWord_target().split("-");
				word.setWord_target(part[0] + " " + part[1]);
			}
			Dictionary.list.add(word);
		}
		
		scan.close();
	}
	
	public void insertFromFile (File file) throws FileNotFoundException {

		Scanner scanFile = new Scanner(file);
		
		while (scanFile.hasNext()) {
			Word word = new Word();
			word.setWord_explain(scanFile.next());
			if (word.getWord_explain().contains("-")) {
				String [] part = word.getWord_explain().split("-");
				word.setWord_explain(part[0] + " " + part[1]);
			}
			word.setWord_target(scanFile.next());
			if (word.getWord_target().contains("-")) {
				String [] part = word.getWord_target().split("-");
				word.setWord_target(part[0] + " " + part[1]);
			}
			Dictionary.list.add(word);		
		}		
		
		scanFile.close();
	}
	
	
	public void dictionaryLookup(String str, Dictionary dic) {
		
		Word word = new Word();
		int i = 0;
		boolean foundWord = false;
		
		while (i < Dictionary.list.size()) {
			word = Dictionary.list.get(i);
			if (word.getWord_explain().equals(str)) {
				System.out.println(word.getWord_target());
				foundWord = true;
			}
			if (word.getWord_target().equals(str)) {
				System.out.println(word.getWord_explain());
				foundWord = true;
			}
			i++;
		}
		if (!foundWord) {
			System.out.println("Your searching word is unavailable.");
		}
	}
}


class DictionaryCommandLine{
	
	private void showAllWords (Dictionary dic) {
		Word word = new Word();
		
		System.out.println("Number		| English		| Vietnamese      ");
		for (int i = 0; i < Dictionary.list.size(); i++) {
			word.setWord_explain(Dictionary.list.get(i).getWord_explain());
			word.setWord_target(Dictionary.list.get(i).getWord_target());
			System.out.print(i+1 + "		|");
			System.out.print(" " + word.getWord_explain());
			System.out.print("			|");
			System.out.print(" " + word.getWord_target());
			System.out.println();
		}	
	}
	
	public void dictionaryBasic (int n, Dictionary dic) {
		DictionaryManagement dicMan = new DictionaryManagement();
		
		dicMan.insertFromCommandLine(n);
		showAllWords(dic);
	}
	
	public void dictionaryAdvanced (Dictionary dic, File file, String str) throws FileNotFoundException {
		DictionaryManagement dicMan = new DictionaryManagement();
		
		dicMan.insertFromFile(file);
		dicMan.dictionaryLookup(str, dic);
		showAllWords(dic);
		
	}
	
}

