package jour01.job01;

import java.util.Scanner;

public class job01 {
    
    public static void main(String[] args) {
        // Create a Scanner object to read input from keyboard
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter something
        System.out.println("Please enter some text:");
        
        // Get the user input as a String
        String userInput = scanner.nextLine();
        
        // Display the input that was entered
        System.out.println("You entered: " + userInput);
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}