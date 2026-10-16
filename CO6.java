import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CO6 {
    public static void main(String[] args) {
        
        // CO6: Collections (ArrayList)
        List<Double> fillLevels = new ArrayList<>();
        fillLevels.add(45.5);
        fillLevels.add(90.0);
        fillLevels.add(10.2);
        fillLevels.add(85.5);
        fillLevels.add(60.0);

        System.out.println("All Fill Levels in Collection: " + fillLevels);

        // CO6: Streams API (Filter out levels below 80, Sort them, Map to String)
        List<String> criticalBins = fillLevels.stream()
            .filter(level -> level >= 80.0) // Keeps only >= 80
            .sorted()                       // Sorts ascending
            .map(level -> "Critical Level: " + level + "%") // Transforms data type
            .collect(Collectors.toList());  // Collects back to a List

        System.out.println("\nProcessed Output using Streams:");
        // CO6: Collections iteration using forEach
        criticalBins.forEach(item -> System.out.println(item));
    }
}
