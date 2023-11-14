/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Scanner;

/**
 *
 * @author yasin.hussein
 */
public class GameSetup {
     private GameSetup() {
        throw new AssertionError("MenuHelper should not be instantiated.");
    }
    public static Game setupGame() {
        System.out.println("Welcome to the Camel Racing!");
        System.out.println("Please select a difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        
        int difficulty = getUserChoice(1, 3);
        
        System.out.println("Please select a camel");
        System.out.println("1. Standard Camel");
        System.out.println("2. Random Camel");
        System.out.println("3. Custom Camel");
        
        int CamelChoice = getUserChoice(1, 3);
        Camel camel = setupCamel(CamelChoice);
        
        System.out.println("Now, it's time to select your rider:");
        System.out.println("1. Average Rider");
        System.out.println("2. Random Rider");
        System.out.println("3. Custom Rider");

        int RiderChoice = getUserChoice(1, 3);
        Rider rider = setupRider(RiderChoice);

        return new Game(difficulty, camel, rider);
    }
    public static Camel setupCamel(int option) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of your camel: ");
        String camelName = scanner.nextLine();

        if (option == 1) {
            return new Camel(camelName);
        } else if (option == 2) {
            return new Camel(camelName, 0, 0, 0); // You can initialize random values here
        } else if (option == 3) {
            // Add logic to create a custom camel based on user input
            return new Camel(camelName); // For this example, just creating a default camel
        }

        return null;
    }
   public static Rider setupRider(int option){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter Your Name: ");
    String riderName = scanner.nextLine();
    
    if (option == 1) {
        return new Rider(riderName);
    } else if (option == 2) {
        return new Rider(riderName, 0, 0, 0); // You can initialize random values here
    } else if (option == 3) {
        // Add logic to create a custom rider based on user input
        return new Rider(riderName); // For this example, just creating a default rider
    }

    return null;
}
    private static int getUserChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < min || choice > max) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric option.");
                scanner.next(); // Consume the invalid input
            }
        }

        return choice;
    }
    
   
}
