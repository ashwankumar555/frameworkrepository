package com.example.my_first_maven_project;

public class ClassMethods {
	static int x = 5;
	//static method
	static void myMethod() {
	    System.out.println("Calling a method of Class type!");
	  }
	 // Public method
	  public void myPublicMethod() {
	    System.out.println("Public methods must be called by creating objects");
	  } 
	public static void main(String[] args) {
		myMethod();
		ClassMethods.myMethod();
		System.out.println(x);
		System.out.println(ClassMethods.x);
		ClassMethods obj = new ClassMethods();
		obj.myPublicMethod();
	}
}