package unipiDBalumni;

import java.util.Scanner;

public class menu {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				System.out.println("Welcome to the UniPi Alumni DB.");
				
				while (true) {
					System.out.println("Select one of the following options:");
					System.out.println("1. Insert new record to STUDENTSdetails table");
					System.out.println("2. ");
					System.out.println("3.");
					System.out.println("4.");
					System.out.println("10. Exit");
					
					Scanner sc = new Scanner(System.in);
					String input = sc.nextLine();
				
					switch (input) {
					case "1":
						System.out.println("Selected 1");
						System.out.println("Enter year: ");
						break;
					case "2":
						System.out.println("Selected 2");
						break;
					case "3":
						System.out.println("Selected 3");
						break;
					case "4":
						System.out.println("Selected 4");
						break;	
					case "10":
						System.out.println("Selected 10");
						break;
					default:
						System.err.println("Invalid input.");
					}
					
				}
			}


	}

