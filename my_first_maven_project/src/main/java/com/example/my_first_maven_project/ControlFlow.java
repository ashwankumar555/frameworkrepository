package com.example.my_first_maven_project;

public class ControlFlow {

	public static void main(String[] args) {

		        int number = 7;

		        // Decision-making
		        if (number > 0) {
		            System.out.println("Positive number");
		        } else if (number < 0) {
		            System.out.println("Negative number");
		        } else {
		            System.out.println("Zero");
		        }

		        // Looping
		        System.out.print("Numbers from 1 to 5: ");
		        for (int i = 1; i <= 5; i++) {
		            System.out.print(i + " ");
		        }
		        System.out.println();

		        // Switch statement
		        switch (number) {
		            case 1:
		                System.out.println("One");
		                break;
		            case 7:
		                System.out.println("Seven");
		                break;
		            default:
		                System.out.println("Other number");
		        }

		        // Jump statement
		        System.out.print("Even numbers from 1 to 5: ");
		        for (int i = 1; i <= 5; i++) {
		            if (i % 2 != 0) {
		                continue; // Skip odd numbers
		            }
		            System.out.print(i + " ");
		            
		        }
		        
		        //If Else ( Even/Odd example)
		        System.out.println();
		        int num = 10;
		        if (num % 2 == 0) {
		            System.out.println(num + " is even.");
		        } else {
		            System.out.println(num + " is odd.");
		        }
		    }
		}

/*Output: Positive number
Numbers from 1 to 5: 1 2 3 4 5 
Seven
Even numbers from 1 to 5: 2 4 
10 is even. */
