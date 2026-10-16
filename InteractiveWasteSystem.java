import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// ==========================================
// CO4: Custom Exceptions
// ==========================================
class OverfillException extends Exception {
    public OverfillException(String message) {
        super(message);
    }
}

// ==========================================
// CO4: Classes & Objects
// CO5: Strings (Formatting and Overriding)
// ==========================================
class GarbageBin implements Comparable<GarbageBin> {
    private String id;
    private double weight;

    public GarbageBin(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() { return id; }
    public double getWeight() { return weight; }

    // CO4: Exception Handling (Throws)
    public void addGarbage(double amount) throws OverfillException {
        if (this.weight + amount > 100.0) {
            throw new OverfillException("Adding " + amount + "kg exceeds the 100kg limit for bin " + id + "!");
        }
        this.weight += amount;
    }

    // CO5: String Formatting
    @Override
    public String toString() {
        return String.format("Bin ID: %-8s | Weight: %.1f kg", id, weight);
    }

    // CO5: Sorting (Comparable interface implementation)
    @Override
    public int compareTo(GarbageBin other) {
        return Double.compare(this.weight, other.weight);
    }
}

public class InteractiveWasteSystem {

    // CO6: Collections (Global ArrayList to store objects across menu options)
    static List<GarbageBin> globalBins = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Pre-loading some data into the collection for convenience
        globalBins.add(new GarbageBin("BIN-A", 45.0));
        globalBins.add(new GarbageBin("BIN-B", 90.0));
        globalBins.add(new GarbageBin("BIN-C", 10.0));

        System.out.println("==================================================");
        System.out.println("   INTERACTIVE WASTE MANAGEMENT SYSTEM");
        System.out.println("==================================================");

        // CO2: Iteration (While loop)
        while (running) {
            System.out.println("\nSelect an operation to test:");
            System.out.println("1. Test CO1: Enter Basic Data (I/O & Data Types)");
            System.out.println("2. Test CO2: Selection & Iteration (If/Else, For loops)");
            System.out.println("3. Test CO3: Methods, Arrays & Recursion");
            System.out.println("4. Test CO4: Classes, Objects & Exceptions (Try adding garbage)");
            System.out.println("5. Test CO5: Strings, Search, Sort & Files (Write custom report)");
            System.out.println("6. Test CO6: Collections & Streams (Filter bins by weight)");
            System.out.println("7. Exit System");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // CO2: Selection (Switch statement)
            switch (choice) {
                case 1:
                    testCO1_Basics(scanner);
                    break;
                case 2:
                    testCO2_SelectionIteration(scanner);
                    break;
                case 3:
                    testCO3_MethodsArraysRecursion(scanner);
                    break;
                case 4:
                    testCO4_ClassesExceptions(scanner);
                    break;
                case 5:
                    testCO5_StringsSearchSortFiles(scanner);
                    break;
                case 6:
                    testCO6_CollectionsStreams(scanner);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }

    // ==========================================
    // CO1: Basics, Data Types & Console I/O
    // ==========================================
    public static void testCO1_Basics(Scanner scanner) {
        System.out.println("\n--- [CO1] Basics & Input ---");
        
        System.out.print("Enter a Zone Code (single character, e.g., Z): ");
        char zone = scanner.nextLine().charAt(0);
        
        System.out.print("Enter total number of trucks (integer): ");
        int trucks = scanner.nextInt();
        
        System.out.print("Enter average bin weight (decimal/double): ");
        double avgWeight = scanner.nextDouble();
        
        System.out.print("Is the system fully operational? (true/false): ");
        boolean isOperational = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        System.out.println("\n>> You entered:");
        System.out.println("Zone: " + zone + " | Trucks: " + trucks + " | Avg Weight: " + avgWeight + " | Operational: " + isOperational);
    }

    // ==========================================
    // CO2: Selection & Iteration
    // ==========================================
    public static void testCO2_SelectionIteration(Scanner scanner) {
        System.out.println("\n--- [CO2] Selection & Iteration ---");
        
        System.out.print("Enter a fill percentage to check status (0-100): ");
        int fill = scanner.nextInt();
        scanner.nextLine();

        // Selection: If-Else
        if (fill >= 90) {
            System.out.println(">> STATUS: CRITICAL! Dispatch truck immediately.");
        } else if (fill >= 50) {
            System.out.println(">> STATUS: WARNING. Bin is half full.");
        } else {
            System.out.println(">> STATUS: NORMAL. No action required.");
        }

        System.out.print("How many times should the warning beacon flash? (Enter a number): ");
        int flashes = scanner.nextInt();
        scanner.nextLine();

        // Iteration: For-loop
        System.out.print(">> Beacon flashing: ");
        for (int i = 1; i <= flashes; i++) {
            System.out.print("*FLASH " + i + "*  ");
        }
        System.out.println();
    }

    // ==========================================
    // CO3: Methods, Arrays, Recursion
    // ==========================================
    public static void testCO3_MethodsArraysRecursion(Scanner scanner) {
        System.out.println("\n--- [CO3] Arrays & Recursion ---");
        
        System.out.print("How many zones do you want to create? ");
        int size = scanner.nextInt();
        scanner.nextLine();
        
        // 1D Array user input
        String[] zones = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name for Zone " + (i + 1) + ": ");
            zones[i] = scanner.nextLine();
        }
        
        System.out.println(">> You created these zones: " + Arrays.toString(zones));

        System.out.print("\nEnter a number to calculate total bins recursively (e.g., 5): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        int result = calculateTotalBinsRecursively(n);
        System.out.println(">> Recursive result for counting " + n + " blocks is: " + result);
    }

    // Helper Method for CO3
    private static int calculateTotalBinsRecursively(int n) {
        if (n <= 0) return 0; // Base condition
        return 1 + calculateTotalBinsRecursively(n - 1); // Recursive call
    }

    // ==========================================
    // CO4: Classes, Objects, Exceptions
    // ==========================================
    public static void testCO4_ClassesExceptions(Scanner scanner) {
        System.out.println("\n--- [CO4] Objects & Exceptions ---");
        
        System.out.print("Let's create a new bin. Enter Bin ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter current weight of the bin (kg): ");
        double initialWeight = scanner.nextDouble();
        
        GarbageBin customBin = new GarbageBin(id, initialWeight);
        globalBins.add(customBin); // Add to our CO6 collection as well
        
        System.out.println(">> Bin created: " + customBin);
        
        System.out.print("How much garbage do you want to add now? (Max limit is 100kg total): ");
        double addAmount = scanner.nextDouble();
        scanner.nextLine();

        // Exception Handling (Try-Catch)
        try {
            customBin.addGarbage(addAmount);
            System.out.println(">> Success! New weight is: " + customBin.getWeight() + " kg");
        } catch (OverfillException e) {
            System.out.println("\n>> [ERROR CAUGHT]: " + e.getMessage());
        }
    }

    // ==========================================
    // CO5: Strings, Search, Sort, Files
    // ==========================================
    public static void testCO5_StringsSearchSortFiles(Scanner scanner) {
        System.out.println("\n--- [CO5] Strings, Search, Sort, Files ---");
        
        String[] binNames = {"Z-Bin", "A-Bin", "M-Bin", "C-Bin"};
        System.out.println("Available String Data: " + Arrays.toString(binNames));
        
        // Sorting Strings
        Arrays.sort(binNames);
        System.out.println(">> Sorted Data: " + Arrays.toString(binNames));

        // Searching Strings
        System.out.print("Enter a bin name to search for (e.g., M-Bin): ");
        String target = scanner.nextLine();
        
        boolean found = false;
        for (String name : binNames) {
            if (name.equalsIgnoreCase(target)) { // String comparison
                found = true;
                break;
            }
        }
        System.out.println(">> Search Result: " + (found ? "Bin Found!" : "Bin Not Found."));

        // File I/O
        System.out.print("\nType a short note to save to a file: ");
        String note = scanner.nextLine();
        String filename = "UserReport.txt";
        
        try {
            // Write
            FileWriter writer = new FileWriter(filename);
            writer.write("User Note:\n" + note);
            writer.close();
            System.out.println(">> File '" + filename + "' written successfully!");

            // Read
            System.out.println(">> Reading from file...");
            Scanner fileReader = new Scanner(new File(filename));
            while (fileReader.hasNextLine()) {
                System.out.println("   " + fileReader.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // ==========================================
    // CO6: Collections & Streams
    // ==========================================
    public static void testCO6_CollectionsStreams(Scanner scanner) {
        System.out.println("\n--- [CO6] Collections & Streams ---");
        
        System.out.println("Current Bins in Collection (ArrayList):");
        globalBins.forEach(bin -> System.out.println(" " + bin.toString()));

        System.out.print("\nEnter a minimum weight threshold to filter critical bins (e.g., 50): ");
        double threshold = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\n>> Generating Filtered & Sorted Stream Report:");
        
        // Streams API: Filter, Sort, Collect
        List<GarbageBin> criticalBins = globalBins.stream()
                .filter(b -> b.getWeight() >= threshold)
                .sorted(Comparator.comparing(GarbageBin::getWeight).reversed()) // Descending order
                .collect(Collectors.toList());

        if (criticalBins.isEmpty()) {
            System.out.println(" No bins meet or exceed the " + threshold + "kg threshold.");
        } else {
            criticalBins.forEach(bin -> System.out.println(" -> CRITICAL: " + bin.toString()));
        }
    }
}
