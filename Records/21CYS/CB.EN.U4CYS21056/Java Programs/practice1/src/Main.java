// Add.java
public class Add {
    public static int add(int a, int b) {
        return a + b;
    }
}

// Multiply.java
public class Multiply {
    public static int multiply(int a, int b) {
        return a * b;
    }
}

// Subtract.java
public class Subtract {
    public static int subtract(int a, int b) {
        return a - b;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        int a = 5, b = 3;

        System.out.println("Addition: " + Add.add(a, b));
        System.out.println("Multiplication: " + Multiply.multiply(a, b));
        System.out.println("Subtraction: " + Subtract.subtract(a, b));
    }
}
