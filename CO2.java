import java.util.Scanner;

public class CO2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        
        // CO2: Iteration (While loop)
        while (keepRunning) {
            System.out.println("\n1. Check Bin Status\n2. Count Bins\n3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            
            // CO2: Selection (Switch case)
            switch (choice) {
                case 1:
                    System.out.print("Enter fill percentage: ");
                    int fillLevel = scanner.nextInt();
                    
                    // CO2: Selection (If-Else)
                    if (fillLevel >= 80) {
                        System.out.println("Alert: Bin is almost full!");
                    } else {
                        System.out.println("Bin is in normal limits.");
                    }
                    break;
                    
                case 2:
                    System.out.print("How many bins to process? ");
                    int count = scanner.nextInt();
                    // CO2: Iteration (For loop)
                    for (int i = 1; i <= count; i++) {
                        System.out.println("Processing bin #" + i);
                    }
                    break;
                    
                case 3:
                    keepRunning = false; // Breaks the while loop
                    System.out.println("Exiting system...");
                    break;
                    
                default:
                    System.out.println("Invalid selection.");
            }
        }
        scanner.close();
    }
}