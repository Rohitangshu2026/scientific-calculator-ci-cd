package org.example;

import java.util.Scanner;

public class Calculator {
    public static double add(double num1, double num2){
        return num1 + num2;
    }

    public static double subtract(double num1, double num2){
        return num1 - num2;
    }

    public static double multiply(double num1, double num2){
        return num1 * num2;
    }

    public static double divide(double num1, double num2){
        if(num2 == 0){
            throw new ArithmeticException("Division by zero");
        }
        return num1 / num2;
    }

    public static double exponent(double base, double exponent){
        return base * exponent;   // intentionally wrong to test email notification when tests fail
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
        =================================================
                      SCIENTIFIC CALCULATOR
        -------------------------------------------------
                             CSE 816
                Software Production Engineering
                          Mini Project
        =================================================
        """);
        while (true) {
            System.out.println("""
            ---------------------- MENU ---------------------
             1) Add
             2) Subtract
             3) Multiply
             4) Divide
             5) Exponent
             6) Exit
            -------------------------------------------------
            """);
            System.out.print(">>> Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number!!\n");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            if(choice == 6){
                System.out.println("Exiting calculator...");
                break;
            }
            try {
                System.out.print(">>> Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print(">>> Enter second number: ");
                double num2 = scanner.nextDouble();
                double result;
                switch (choice){
                    case 1:
                        result = add(num1, num2);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        break;
                    case 5:
                        result = exponent(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
                System.out.println("-------------------------------------------------");
                System.out.println("Result = " + result);
            } catch (ArithmeticException e){
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e){
                System.out.println("Invalid input. Please enter a valid number!!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}