package com.example.my_first_maven_project;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

public class ArraysClass {

	public static void main(String[] args) {
		//asList()   Converts an array to a fixed-size list backed by the specified array.
		String[] arr = {"Apple", "Banana", "Cherry"};
		List<String> list = Arrays.asList(arr);
		System.out.println(arr[1]);				//Banana
		System.out.println(list);				//[Apple, Banana, Cherry]
		
		//binarySearch()   Performs a binary search on a sorted array to find the specified element
		int[] arr2 = {10, 20, 30, 40, 50};
		int index = Arrays.binarySearch(arr2, 30); 
		System.out.println(index);				// Returns 2
		
		//compare()     Compares two arrays lexicographically
		int[] arr3 = {1, 2, 3};
		int[] arr4 = {1, 2, 4};
		int result = Arrays.compare(arr3, arr4);
		System.out.println(result);				//Returns a negative number   -1
		
		//copyof()    Copies the specified array, truncating or padding with default 
		//values to achieve the specified length.
		int[] orginal = {1,2,3};
		int[] copy = Arrays.copyOf(orginal, 9);
		for (int x=0;x<copy.length;x++)
		{
		System.out.print(copy[x]+" ");
		}
		System.out.println();
		
		//copyOfRange()    Copies a specified range from the original array into a new array
		int[] original2 = {1,2,3,4,5,6,7,8};
		int[] copied = Arrays.copyOfRange(original2, 3, 6);
		for(int y=0;y<copied.length;y++)
		{
			System.out.print(copied[y]+" ");
		}
		System.out.println();
		
		//deepEquals()   Compares two multidimensional arrays to check whether they are deeply equal
		int[][] arr5 = {{1, 2}, {3, 4}};
		int[][] arr6 = {{1, 2}, {3, 4}};
		boolean isEqual = Arrays.deepEquals(arr5, arr6);
		System.out.println(isEqual);			//true
		
		System.out.println();
		//equals()  Checks if two arrays are equal, meaning they have the same length 
		//and corresponding elements are equal.
		int[] arr7 = {1, 2, 3};
		int[] arr8 = {1, 2, 3};
		boolean isEquals = Arrays.equals(arr7, arr8);
		System.out.println(isEquals);			//true
		
		//fill()  Assigns the specified value to each element of the specified array
		int[] arr9 = new int[5];
		Arrays.fill(arr9, 10); // {10, 10, 10, 10, 10}
		for(int z=0;z<arr9.length;z++)
		{
			System.out.print(arr9[z]+" ");       //10 10 10 10 10
		}
		System.out.println();
		
		//hashCode()      Returns a hash code based on the contents of the specified array
		int[] arr10 = {1, 2, 3};
		int hash = Arrays.hashCode(arr10);
		System.out.println(hash);				//30817
		System.out.println();
		
		//mismatch()  Finds and returns the index of the first mismatch between two arrays; 
		//returns -1 if no mismatch is found.
		int[] arr11 = {1, 2, 3};
		int[] arr12 = {1, 3, 3};
		int index2 = Arrays.mismatch(arr11, arr12); 
		System.out.println(index2);				// Returns 1
		
		//parallelSort()   Sorts the specified array into ascending order using parallel sorting.
		int[] arr13 = {5, 2, 8, 1, 3};
		Arrays.parallelSort(arr13); 
		for(int p=0;p<arr13.length;p++)
		{
			System.out.print(arr13[p]+" ");       //1 2 3 5 8
		}
		System.out.println();
		
		//setAll() Sets all elements of the specified array using the provided generator function.
		int[] arr14 = new int[5];
		Arrays.setAll(arr14, i -> i * 2);
		for(int q=0;q<arr14.length;q++)
		{
			System.out.print(arr14[q]+" ");       //0 2 4 6 8
		}
		System.out.println();
		
		//sort()   Sorts the specified array into ascending order.
		int[] arr15 = {5, 2, 8, 1, 3};
		Arrays.sort(arr15); 
		for(int r=0;r<arr15.length;r++)
		{
			System.out.print(arr15[r]+" ");       //1 2 3 5 8
		}
		System.out.println();
		
		//spliterator()  Returns a Spliterator covering all of the specified array
		int[] arr16 = {1, 2, 3};
		Spliterator.OfInt spliterator = Arrays.spliterator(arr16);
		System.out.println(spliterator);
		System.out.println();
		
		//stream() Returns a sequential Stream with the specified array as its source.
		int[] arr17 = {1, 2, 3};
		IntStream stream = Arrays.stream(arr17);
		System.out.println(stream);
		
		//toString()   Returns a string representation of the contents of the specified array
		int[] arr18 = {1, 2, 3};
		String str = Arrays.toString(arr18); 
		System.out.println(str);
	}
}
