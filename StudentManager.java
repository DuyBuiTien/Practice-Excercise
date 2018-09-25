package edu.name.javabasic;

import java.util.Scanner;

public class StudentManager {

/**
 *
 * @author DuyBuiTien
 */

	static Student [] studentGroup = new  Student[3];
	
	
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	
    	for(int i = 0; i < 3; ++i) {
    		studentGroup[i] = new Student();
    	}
    	
    	for(int i = 0; i < 3; i++) {
    		
    		String name = scan.nextLine();
    		String id = scan.nextLine();
    		String group = scan.nextLine();
    		String email = scan.nextLine();
    		
    		studentGroup[i].setName(name);
    		studentGroup[i].setID(id);
    		studentGroup[i].setGroup(group);
    		studentGroup[i].setEmail(email);
    		
    	}
        
        scan.close();
        
       
        
    }
    
    public static void studentsByGroup() { 
    	for(int i = 0; i < 2; ++i) {
    		for(int j = i + 1; j < 3; ++j) {
    			if(studentGroup[i].getGroup() == studentGroup[j].getGroup()) {
    				
    			}
    		}
    	}
    }
    
    public static void removeStudent(String id) {
    	
    }
    
    public static boolean sameGroup(Student s1, Student s2) {
    	if( s1.getName().equals(s2.getName())
    	    && s1.getName().equals(s2.getName())
    	    && s1.getID().equals(s2.getID()) 
    	    && s1.getGroup().equals(s2.getGroup())) {
    		return true;
    	}
    	else
    		return false;
    }
}
class Student{
    private String id;
    private String name;
    private String group;
    private String email;
    
    public Student() {
    	this.name   = "Student";
    	this.id     = "000";
    	this.group  = "K60CC";
    	this.email  = "uet@vnu.edu.vn";

    }
    
    public Student(String nid, String n, String em){
    	this.name   = nid;
    	this.id     = n;
    	this.email  = em;
    	this.group  = "K62CC";
    }
    
    public Student(Student s) {
    	this.name   = s.name;
    	this.id     = s.id;
    	this.group  = s.group;
    	this.email  = s.email;
    }
    
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return this.name;
    }
    
    public void setID(String n){
        this.id = n;
    }
    public String getID(){
        return this.id;
    }
    
    public void setGroup(String n){
        this.group = n;
    }
    public String getGroup(){
        return this.group;
    }
    
    public void setEmail(String n){
        this.email = n;
    }
    public String getEmail(){
        return this.email;
    }
    

    public void getInfor(){
        System.out.println("Name : "  + this.name);
        System.out.println("ID : "    + this.id);
        System.out.println("Group : " + this.group);
        System.out.println("Email : " + this.email);

    }
}

