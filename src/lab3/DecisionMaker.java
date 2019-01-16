package lab3;
import java.util.Scanner;

public class DecisionMaker {
	static Scanner scnr = new Scanner(System.in);
	static String name = name();
	static int input;
	
	public static void main(String[] args) {
		boolean retry = true;
		
		header();
		while (retry) {
			userInt();
			range();
			retry = retry();
		}
		exit();
		scnr.close();
	}
	
	public static String name() {
		System.out.println("Please enter your name: ");
		return scnr.nextLine();		
	}

	public static void header() {
		System.out.println("Welcome " + name + ", to the Automated Decision-Maker\n");
	}
	
	public static void userInt() {
		boolean valid = false;
		String inputString;
		while (!valid) {
			System.out.print("Please input an integer between 1 and 100: ");
			inputString = scnr.nextLine();
			valid = tryParseInt(inputString);
		}
	}
	
	public static boolean tryParseInt(String inputString) {
		boolean valid = true;
		for (int i = 0; i < inputString.length(); i++) {
			int x = inputString.charAt(i);
			if (!(x >= 48 && x <= 57)) {
				valid = false;
				break;
			}
		}
		if (valid) {
			input = Integer.parseInt(inputString);
			if ((input > 0) && (input < 100)) {
				return true;
			}
			else {
				System.out.println(name + ", please read the directions and try again...");
				return false;
			}
		}
		else {
			System.out.println(name + ", please read the directions and try again...");
			return false;
		}
	}
	
	public static void range() {
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
	
	public static boolean retry() {
		char cont = ' ';
		System.out.print("Continue? (y/n) ");
		cont = scnr.nextLine().charAt(0);
		while(cont != 'y' && cont != 'Y' && cont != 'n' && cont != 'N') {
		System.out.println(name + ", what was that?... type 'y' to continue or 'n' to exit");
		cont = scnr.nextLine().charAt(0);
		}		
		if (cont == 'y' || cont == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void exit() {
		System.out.println("GOODBYE " + name + "!");
	}
}
