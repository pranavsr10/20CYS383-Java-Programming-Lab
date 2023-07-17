import java.util.Scanner;

abstract class Calculator {
    protected double num1;
    protected double num2;

    public void readNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();
    }

    public abstract double calculate();

    public void displayResult(double result) {
        System.out.println("The result is: " + result);
    }
}

class Addition extends Calculator {
    @Override
    public double calculate() {
        return num1 + num2;
    }
}

class Subtraction extends Calculator {
    @Override
    public double calculate() {
        return num1 - num2;
    }
}

class Multiplication extends Calculator {
    @Override
    public double calculate() {
        return num1 * num2;
    }
}

class Division extends Calculator {
    @Override
    public double calculate() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Error: Division by zero!");
            return 0;
        }
    }
}

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = scanner.nextInt();
        Calculator calculator;

        switch (choice) {
            case 1:
                calculator = new Addition();
                break;
            case 2:
                calculator = new Subtraction();
                break;
            case 3:
                calculator = new Multiplication();
                break;
            case 4:
                calculator = new Division();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        calculator.readNumbers();
        double result = calculator.calculate();
        calculator.displayResult(result);
    }
}

