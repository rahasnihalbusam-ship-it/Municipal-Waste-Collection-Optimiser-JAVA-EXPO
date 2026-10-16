import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CO5 {
    public static void main(String[] args) {
        
        // CO5: Strings
        String[] bins = {"Z-Bin", "A-Bin", "M-Bin", "C-Bin"};
        System.out.println("Original String Array: " + Arrays.toString(bins));
        
        // CO5: Sorting
        Arrays.sort(bins);
        System.out.println("Sorted String Array: " + Arrays.toString(bins));
        
        // CO5: Search (Linear Search using String .equals)
        String searchTarget = "M-Bin";
        boolean found = false;
        for (String bin : bins) {
            if (bin.equals(searchTarget)) {
                found = true;
                break;
            }
        }
        System.out.println("Search Result for " + searchTarget + ": " + (found ? "Found" : "Not Found"));

        // CO5: Files (Writing to a file)
        String fileName = "CO5_Output.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Sorted Bins List:\n");
            for (String b : bins) {
                writer.write(b + "\n");
            }
            writer.close();
            System.out.println("\nFile Written successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
        }

        // CO5: Files (Reading from a file)
        try {
            System.out.println("Reading from " + fileName + ":");
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading.");
        }
    }
}
