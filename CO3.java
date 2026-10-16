public class CO3 {
    
    public static void main(String[] args) {
        // CO3: 1D Array
        String[] zones = {"North", "South", "East"};
        
        // CO3: Method call
        displayZones(zones);
        
        // CO3: 2D Array
        int[][] distanceMatrix = {
            {0, 5, 10},
            {5, 0, 7},
            {10, 7, 0}
        };
        displayDistances(distanceMatrix);
        
        // CO3: Recursion
        int total = countRecursively(5);
        System.out.println("\nRecursive Count result for 5 bins: " + total);
    }

    // CO3: Custom Method & 1D Array processing
    public static void displayZones(String[] zones) {
        System.out.println("--- City Zones ---");
        for (int i = 0; i < zones.length; i++) {
            System.out.println("Zone " + (i+1) + ": " + zones[i]);
        }
    }

    // CO3: Processing 2D Arrays
    public static void displayDistances(int[][] matrix) {
        System.out.println("\n--- Distance Matrix ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " km\t");
            }
            System.out.println();
        }
    }

    // CO3: Recursion
    public static int countRecursively(int n) {
        if (n <= 0) return 0; // Base case
        return 1 + countRecursively(n - 1); // Method calls itself
    }
}
