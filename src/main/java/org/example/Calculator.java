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

    public static double squareRoot(double num){
        if(num < 0){
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(num);
    }

    public static double exponent(double base, double exponent){
        return Math.pow(base, exponent);
    }

    public static double naturalLog(double num){
        if(num <= 0){
            throw new ArithmeticException("Log of non-positive number");
        }
        return Math.log(num);
    }

    public static double factorial(int num){
        if(num < 0){
            throw new ArithmeticException("Factorial of negative number");
        }

        double result = 1;

        for(int i = 1; i <= num; i++){
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
             5) Square Root
             6) Exponent
             7) Natural Log
             8) Factorial
             9) Exit
            -------------------------------------------------
            """);
            System.out.print(">>> Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number!!\n");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            if(choice <= 0 || choice > 9){
                System.out.println("Error: Invalid choice. Please try again.\n");
                continue;
            }

            if(choice == 9){
                System.out.println("Exiting calculator...");
                break;
            }
            try {
                System.out.print(">>> Enter number: ");
                double num1 = scanner.nextDouble();
                double num2 = 0;
                if((choice >= 1 && choice <= 4) || choice == 6){
                    System.out.print(">>> Enter second number: ");
                    num2 = scanner.nextDouble();
                }
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
                        result = squareRoot(num1);
                        break;
                    case 6:
                        result = exponent(num1, num2);
                        break;
                    case 7:
                        result = naturalLog(num1);
                        break;
                    case 8:
                        result = factorial((int) num1);
                        break;
                    default:
                        System.out.println("Error: Invalid choice");
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