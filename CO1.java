import java.util.Scanner;

public class CO1 {
    public static void main(String[] args) {
        // CO1: Basics and Data Types
        int binNumber = 101;
        double fillWeight = 45.5;
        boolean isFull = false;
        
        // CO1: Console I/O (Input)
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Waste System Data Entry ---");
        System.out.print("Enter Bin Area Code (e.g., A, B, C): ");
        char areaCode = scanner.next().charAt(0);
        
        System.out.print("Enter current bin weight (kg): ");
        fillWeight = scanner.nextDouble();
        
        // CO1: Console I/O (Output)
        System.out.println("\n--- Data Saved ---");
        System.out.println("Bin Number: " + binNumber);
        System.out.println("Area Code: " + areaCode);
        System.out.println("Current Weight: " + fillWeight + " kg");
        System.out.println("Is Full: " + isFull);
        
        scanner.close();
    }
}