package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printTasks();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> calculateFactorial(scanner);
            case 2 -> convertNumbersToWords(scanner);
            case 3 -> calculateCircleProps(scanner);
            case 4 -> swapTwoNumbers(scanner);
            case 5 -> findActualPrice(scanner);
            case 6 -> reverseANumber(scanner);
            case 7 -> enterValidPassword(scanner);
            case 8 -> convertToSequence(scanner);


            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }


    }

    private static void printTasks() {
        System.out.print("1-calculateFactorial\n" +
                "2-convertNumbersToWords\n" +
                "3-calculateCircleProps\n" +
                "4-swapTwoNumbers\n" +
                "5-findActualPrice\n" +
                "6-reverseANumber\n" +
                "7-enterValidPassword\n" +
                "8-convertToSequence\n");
    }

    private static void convertToSequence(Scanner scanner) {
        System.out.print("Enter your pattern:");
        String pattern = scanner.next();
        pattern = toLowercasePattern(pattern);
        //checkCasesWithIf(pattern);
        checkCasesWithSwitch(pattern);
        printNumericalPattern(pattern);
    }

    private static String checkCasesWithSwitch(String pattern) {
        String convertedPattern = "";
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            switch (temp) {
                case 'a', 'c', 'b' -> convertedPattern += "2";

                case 'd', 'f', 'e' -> convertedPattern += "3";

                case 'g', 'i', 'h' -> convertedPattern += "4";

                case 'j', 'l', 'k' -> convertedPattern += "5";

                case 'm', 'o', 'n' -> convertedPattern += "6";

                case 'p', 's', 'r', 'q' -> convertedPattern += "7";

                case 't', 'v', 'u' -> convertedPattern += "8";

                case 'w', 'y', 'z', 'x' -> convertedPattern += "9";

                default -> throw new IllegalStateException("Unexpected value: " + temp);
            }
        }
        return convertedPattern;
    }

    private static void printNumericalPattern(String pattern) {
        System.out.println(checkCasesWithIf(pattern));
    }

    private static String checkCasesWithIf(String pattern) {
        String convertedPattern = "";
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);

            if (temp == 'a' || temp == 'b' || temp == 'c') {
                convertedPattern += "2";

            } else if (temp == 'd' || temp == 'e' || temp == 'f') {
                convertedPattern += "3";
            } else if (temp == 'g' || temp == 'h' || temp == 'i') {
                convertedPattern += "4";
            } else if (temp == 'j' || temp == 'k' || temp == 'l') {
                convertedPattern += "5";
            } else if (temp == 'm' || temp == 'n' || temp == 'o') {
                convertedPattern += "6";
            } else if (temp == 'p' || temp == 'q' || temp == 'r' || temp == 's') {
                convertedPattern += "7";
            } else if (temp == 't' || temp == 'u' || temp == 'v') {
                convertedPattern += "8";
            } else if (temp == 'w' || temp == 'x' || temp == 'y' || temp == 'z') {
                convertedPattern += "9";
            } else {
                convertedPattern = "Invalid Input";
            }
        }
        return convertedPattern;

    }

    private static String toLowercasePattern(String pattern) {
        return pattern.toLowerCase(Locale.ROOT);
    }

    private static void enterValidPassword(Scanner scanner) {
        System.out.print("Enter a password:");
        String pass = scanner.next();
        pass = enterValidPassword(scanner, pass);
        printPassword(pass);
    }

    private static void printPassword(String pass) {
        System.out.println("the password is :" + pass);
    }

    private static String enterValidPassword(Scanner scanner, String pass) {
        int flag = 0;
        int stopWhile = 0;
        while (stopWhile != 1) {
            if (pass.length() > 8) {
                for (int i = 0; i <= 9; i++) {
                    String temp = Integer.toString(i);
                    if (pass.contains(temp)) {
                        flag = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 0) {
                    System.out.println("Your password should contain at least a number!");
                    pass = scanner.next();
                } else {
                    stopWhile++;
                }
            } else {
                System.out.println("The minimum length of a password is 8!");
                pass = scanner.next();
            }
        }
        return pass;
    }

    private static void reverseANumber(Scanner scanner) {
        System.out.print("Enter a positive integer:");
        int number = scanner.nextInt();
        number = enterValidateInput(scanner, number);
        reverseDigits(number);
        printReversedNumber(number);//is it good practice  using another loop only for printing?

    }

    private static void printReversedNumber(int number) {
        System.out.print("The reverse is: ");
        for (int i = 0; i < reverseDigits(number).length; i++) {
            System.out.print(reverseDigits(number)[i]);
        }
    }


    private static int[] reverseDigits(int number) {
        int numDigits = String.valueOf(number).length();
        int[] reversedNumber = new int[numDigits];
        for (int i = 0; i < numDigits; i++) {
            reversedNumber[i] = number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }

    private static void findActualPrice(Scanner scanner) {
        // and print the results rounded to 2 decimal places.????
        // is infinite loop suitable in this scenario?
        while (true) {
            System.out.print("Enter the tax-inclusive price in dollars (or -1 to end):");
            double taxInclusivePrice = scanner.nextDouble();
            taxInclusivePrice = enterValidateInput(scanner, taxInclusivePrice);
            if (taxInclusivePrice == -1) {
                break;
            }
            findTaxPart(taxInclusivePrice);
            findActualPrice(taxInclusivePrice);
            printActualAndTaxPrice(taxInclusivePrice);

        }
    }

    private static void printActualAndTaxPrice(double taxInclusivePrice) {
        System.out.println("Actual Price is: $" + (double) findActualPrice(taxInclusivePrice) + ", Sales Tax is: $" + findTaxPart(taxInclusivePrice));
    }

    private static double findActualPrice(double taxInclusivePrice) {
        return taxInclusivePrice - findTaxPart(taxInclusivePrice);
    }

    private static double findTaxPart(double taxInclusivePrice) {
        double percentageOfTax = 0.07;
        return Math.floor(taxInclusivePrice * percentageOfTax);
    }

    private static double enterValidateInput(Scanner scanner, double taxInclusivePrice) {
        while (taxInclusivePrice < 0 || taxInclusivePrice == -1) {
            if (taxInclusivePrice == -1) {
                break;
            } else if (taxInclusivePrice < 0) {
                System.out.println("Please, input a positive number!");
                taxInclusivePrice = scanner.nextInt();
            }
        }
        return taxInclusivePrice;
    }

    private static void swapTwoNumbers(Scanner scanner) {
        System.out.print("Enter the first number:");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number:");
        int num2 = scanner.nextInt();
        swapTwoNumbers(num1, num2);
    }

    private static void swapTwoNumbers(int num1, int num2) {
        num1 = num1 * num2;
        num2 = num1 / num2;
        num1 = num1 / num2;
        System.out.println("After the swap, first integer is:" + num1 + " second integer:" + num2);

    }

    private static void calculateCircleProps(Scanner scanner) {
        System.out.println("Enter the radius of a circle:");
        double radius = scanner.nextDouble();
        radius = enterValidateInput(scanner, (int) radius);

        calculateDiameterOfCircle(radius);
        calculateCircleArea(radius);
        calculateCircleLength(radius);
        printCircleProps(radius);
    }

    private static void printCircleProps(double radius) {
        System.out.println("Diameter of a given circle is: " + calculateDiameterOfCircle(radius));
        System.out.println("Length of a given circle is: " + calculateCircleLength(radius));
        System.out.println("Area of a given circle is: " + calculateCircleArea(radius));
    }

    private static double calculateCircleLength(double radius) {
        return calculateDiameterOfCircle(radius) * Math.PI;
    }

    private static double calculateCircleArea(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    private static double calculateDiameterOfCircle(double radius) {
        return radius * 2;
    }

    private static void convertNumbersToWords(Scanner scanner) {
        System.out.println("Enter the number that I have to convert to a word:");
        int num = scanner.nextInt();
        num = enterValidateInput(scanner, num);
        printConvertedNumbers(num);

    }

    private static void printConvertedNumbers(int num) {
        switch (num) {
            case 1 -> System.out.println(num + "- ONE");
            case 2 -> System.out.println(num + "- TWO");
            case 3 -> System.out.println(num + "- THREE");
            case 4 -> System.out.println(num + "- FOUR");
            case 5 -> System.out.println(num + "- FIVE");
            case 6 -> System.out.println(num + "- SIX");
            case 7 -> System.out.println(num + "- SEVEN");
            case 8 -> System.out.println(num + "- EIGHT");
            case 9 -> System.out.println(num + "- NINE");


        }
    }

    private static void calculateFactorial(Scanner scanner) {
        System.out.print("Enter the number which factorial I have to calculate:");
        int num = scanner.nextInt();
        num = enterValidateInput(num, scanner);
        calculateFactorial(num);
        printFactorial(num);
    }

    private static void printFactorial(int num) {
        int result = calculateFactorial(num);
        System.out.println("Factorial of a " + num + " is " + result);
    }

    private static int calculateFactorial(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int enterValidateInput(Scanner scanner, int num) {
        while (num <= 0) {
            if (num <= 0) {
                System.out.println("Please, input a positive number!");
                num = scanner.nextInt();
            }
        }
        return num;

    }

    private static int enterValidateInput(int num, Scanner scanner) {
        while (num < 0) {
            if (num < 0) {
                System.out.println("Please, input a positive number!");
                num = scanner.nextInt();
            }
        }
        return num;
    }
}
