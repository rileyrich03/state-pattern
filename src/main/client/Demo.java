package client;

import java.util.Scanner;
import state.Mover;
import state.PostalService;

public class Demo{

    public static void main(String[] args) {

	Scanner kb = new Scanner(System.in);
	boolean exit = false;
	int choice = 0;
	while (!exit) {
            String input = "";
            while (!valid(input)) {
                System.out.print("Choose from the following menu\n\n");
                System.out.print("1) About\n2) Run Program\n3) Exit\n\n");
                input = kb.nextLine();
                if (!valid(input))
                    System.out.println("Please select a real option.");
            }
	    switch (Integer.parseInt(input)) {
		case 1:
		    System.out.print("\nThe following program uses the state pattern\n"
			+ "The program will deliver a letter at varying speeds depending on your selection\n"
			+ "It does so by using the same method but changing the class that performs the same"
                        + " method with different outcomes.\nThis allows more speeds/states of the mailman to be added on if needed.\n\n"); 
		    break;
		case 2:
		    System.out.print("Please select the distance(in feet) you would like to deliver the letter.\n");	
	            boolean flip = true;
	            int distance = 0;
	            while(flip) {
	                try {
		            distance = Integer.parseInt(kb.nextLine());
			    flip = false;
	    	        }
	                catch (NumberFormatException e) {
			    System.out.print("Please make a valid selection.\n");
	    	        }
		    }
		    
		    System.out.print("Please enter \nAn even number for a running mail man\n---OR---\nAn odd number for a walking mail man\n");	
	            flip = true;
	            int speed = 0;
	            while(flip) {
	                try {
		            speed = Integer.parseInt(kb.nextLine());
			    flip = false;
	    	        }
	                catch (NumberFormatException e) {
			    System.out.print("Please make a valid selection.\n");
	    	        }
		    }
		    PostalService ps = new PostalService(speed);
		    ps.deliver(distance);
		    break;
		case 3:
		    exit = true;
		    break;
		default:
       	        break;
	    }
	} 

    }
    private static boolean valid(String selection) {
        try {
            int choice = Integer.parseInt(selection);
            return (choice == 1 || choice == 2 || choice == 3);
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
