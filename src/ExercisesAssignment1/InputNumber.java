package ExercisesAssignment1;

import java.util.Scanner;

public class InputNumber {

    public static boolean isInteger(String str) {
        char[] stringToCharArray = str.toCharArray();
        for (char c : stringToCharArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void inputNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean toContinue = true;
        while (toContinue) {
            System.out.println("Please enter an integer number between 1 and 10: ");
            String input = scanner.next();
            if (!isInteger(input)) {
                System.out.println("Only integer numbers are accepted.");
                toContinue = true;
                continue;
            }
            //  i know we havent said about wrapper classes but a simple google search (to convert string to an integer) gives you that method....
            int inputNumber = Integer.parseInt(input);

            if ((inputNumber < 1) || (inputNumber > 10)) {
                System.out.println("The number you entered is outside the range specified.");
                toContinue = true;
                continue;
            } else {
                System.out.println("The number you entered was " + inputNumber);
                System.out.println("Thank you! Goodbye!");
                toContinue = false;
                break;
            }
        }
    }
}
