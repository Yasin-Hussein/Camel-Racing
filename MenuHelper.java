package Game;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yasin.hussein
 */
public class MenuHelper {
    
    private MenuHelper() {
        throw new AssertionError("MenuHelper should not be instantiated.");
    }
    public static int displaymenu(String message, int min, int max) {
      Scanner scan = new Scanner(System.in);  
      int option = -1;

        while (option < min || option > max) {
            System.out.println(message);
            System.out.print("Enter your choice: ");

            if (scan.hasNextInt()) {
                option = scan.nextInt();
                if (option < min || option > max) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric option.");
                scan.next(); // Consume the invalid input
            }
        }

        return option;
    }
    public static String getInput(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        return scan.nextLine();
    
    }
    
}
