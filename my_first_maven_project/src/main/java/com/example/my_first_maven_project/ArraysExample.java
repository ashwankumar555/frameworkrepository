package com.example.my_first_maven_project;

import java.util.List;

public class ArraysExample {

	public static void main(String[] args) {
		
		//Single dimension array
		int[] numbers = {1, 2, 3, 4, 5};
		System.out.println("1st character of array is "+numbers[0]);
		System.out.println("Length of single dimension array is: "+numbers.length);
		
		//Multi dimension array
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
				};
			System.out.print(matrix[0][0]+" ");
			System.out.print(matrix[0][1]+" ");
			System.out.print(matrix[0][2]+" ");
			System.out.println();
			System.out.print(matrix[1][0]+" ");
			System.out.print(matrix[1][1]+" ");
			System.out.print(matrix[1][2]+" ");
			System.out.println();
			System.out.print(matrix[2][0]+" ");
			System.out.print(matrix[2][1]+" ");
			System.out.print(matrix[2][2]+" ");
			System.out.println();
			System.out.println("Length of multi dimension array is: "+matrix.length);
			System.out.println(matrix.clone());
			System.out.println(matrix.clone().length);
			
			// Iterate using a traditional for loop
			for (int i = 0; i < numbers.length; i++) {
			    System.out.print(numbers[i]+" ");
			}
			System.out.println();
			// Iterate using a for-each loop
			for (int num : numbers) {
			    System.out.print(num+" ");
			}
			System.out.println();
			//Finding the Sum and Average
			int sum = 0;
			for (int num : numbers) {
			    sum += num;
			}
			double average = (double) sum / numbers.length;
			System.out.println("Sum: " + sum); // Output: 15
			System.out.println("Average: " + average); // Output: 3.0
			System.out.println();
			// Iterating over a 2D array
			for (int i = 0; i < matrix.length; i++) {
				
			    for (int j = 0; j < matrix[i].length; j++) {
			        System.out.print(matrix[i][j] + " ");
			    }
			    System.out.println();
			}
	}
	
}