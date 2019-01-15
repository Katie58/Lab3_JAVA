package lab3;
import java.util.Scanner;

public class DecisionMaker {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		boolean retry = true;
		String name = Name();
		
		Header(name);
		while (retry) {
			Range(UserInt(name), name);
			
			retry = Continue();
		}
		Exit(name);
		scnr.close();
	}
	
	public static String Name() {
		System.out.println("Please enter your name: ");
		return scnr.nextLine();		
	}

	public static void Header(String name) {
		System.out.println("Welcome " + name + ", to the Automated Decision-Maker\n");
	}
	
	public static int UserInt(String name) {
		boolean valid = false;
		int input = 0;
		while (!valid) {
			System.out.print("Please input an integer between 1 and 100: ");
			input = scnr.nextInt();
			if ((input > 0) && (input < 100)) {
				valid = true;
			}
			else {
				System.out.println(name + ", please read the directions and try again...");
			}
		}
		return input;
	}
	
	public static void Range(int input, String name) {
		if ((input % 2) == 1) {
			System.out.print(input + " is Odd");
			if (input > 60) {
				System.out.print(" and over 60.");
			}
			System.out.print("\n");
		}
		else {		
			if (input > 1 && input <= 25) {
				System.out.println("Even and less than 25");
			}
			else if (input > 25 && input <= 60) {
				System.out.println("Even");
			}
			else if (input > 60) {
				System.out.println(input + "Even");
			}
			else {
				System.out.println("Sorry " + name + ", I am not programmed to provide a response to that input.");
			}
		}
	}
	
	public static boolean Continue() {
		char cont = ' ';
		while(cont != 'y' && cont != 'Y' && cont != 'n' && cont != 'N') {
		System.out.println("Continue? (y/n) ");
		cont = scnr.next().charAt(0);
		}
		
		if (cont == 'y' || cont == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void Exit(String name) {
		System.out.println("GOODBYE " + name + "!");
	}
}
