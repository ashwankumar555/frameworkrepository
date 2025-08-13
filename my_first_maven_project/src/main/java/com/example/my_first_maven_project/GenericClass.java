package com.example.my_first_maven_project;
//Generics allow you to write classes, interfaces, and methods that work with different data types, 
//without having to specify the exact type in advance. This makes your code more flexible, reusable, and type-safe.
class Box<T> {
	  T value; // T is a placeholder for any data type
	  void set(T value) {
	    this.value = value;
	  }
	  T get() {
	    return value;
	  }
	}
public class GenericClass {
	public static void main(String[] args) {
		Box<String> stringBox = new Box<>();
	    stringBox.set("Hello");
	    System.out.println("Value: " + stringBox.get());
	    // Create a Box to hold an Integer
	    Box<Integer> intBox = new Box<>();
	    intBox.set(50);
	    System.out.println("Value: " + intBox.get());
	}
}