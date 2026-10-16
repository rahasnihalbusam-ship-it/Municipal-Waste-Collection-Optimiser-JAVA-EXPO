// CO4: Custom Exception
class OverfillException extends Exception {
    public OverfillException(String message) {
        super(message);
    }
}

// CO4: Classes
class GarbageBin {
    private String id;
    private int weight;

    public GarbageBin(String id) {
        this.id = id;
        this.weight = 0;
    }

    // CO4: Exceptions (Throws keyword)
    public void addGarbage(int amount) throws OverfillException {
        if (this.weight + amount > 100) {
            throw new OverfillException("Adding " + amount + "kg exceeds the 100kg limit for bin " + id);
        }
        this.weight += amount;
        System.out.println("Added " + amount + "kg. Current weight: " + this.weight + "kg");
    }
}

public class CO4 {
    public static void main(String[] args) {
        // CO4: Object Creation
        GarbageBin bin1 = new GarbageBin("B-101");

        // CO4: Try-Catch Exception Handling
        try {
            bin1.addGarbage(50);
            bin1.addGarbage(60); // This will trigger the exception
        } catch (OverfillException e) {
            System.out.println("EXCEPTION CAUGHT: " + e.getMessage());
        } finally {
            System.out.println("Finished adding garbage.");
        }
    }
}
