
package ExercisesAssignment1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BootCampProgram {

    static ArrayList<BootCamp> bootcamps = new ArrayList<>();
    static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d MMMM uuuu");
    static Scanner sc = new Scanner(System.in);
    static int bootcampNumber = BootCamp.getCount() + 1;

    public static boolean isAlphabet(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static boolean containsOnlyAlphabet(String str) {
        char[] stringToCharArray = str.toCharArray();
        for (char c : stringToCharArray) {
            if (!isAlphabet(c)) {
                return false;
            }
        }
        return true;
    }

    public static LocalDate enterDate(String str, BootCamp bootcamp) {
        LocalDate date = null;
        LocalDate updatedDate = null;
        //loop to enter start year:
        boolean isYearCorrect = false;
        int year = 0;
        while (!isYearCorrect) {
            System.out.println("Please enter BootCamp " + bootcamp.getName() + " " + str + " year: ");
            // check for integer
            if (!sc.hasNextInt()) {
                System.out.println("Please enter an integer number for years. ");
                //sc.next(); 
                isYearCorrect = false;
                continue;
            }
            year = sc.nextInt();
            //check for valid year number.
            if ((year < 2020) || (year > 2023)) {
                System.out.print("Number outside allowed range. The starting year must be from this year (2020) up to 3 years ahead (2023).");
                isYearCorrect = false;
                continue;
            }
            isYearCorrect = true;
        }
        //loop to enter starting month
        boolean isMonthCorrect = false;
        int month = 0;
        while (!isMonthCorrect) {
            System.out.println("Please enter BootCamp " + bootcamp.getName() + " " + str + " month using an Integer Number (1-12): ");
            // check for integer
            if (!sc.hasNextInt()) {
                System.out.println("Only integer numbers are allowed. ");
                isMonthCorrect = false;
                sc.next();
                continue;
            }
            month = sc.nextInt();
            //check for valid month number.
            if ((month < 1) || (month > 12)) {
                System.out.print("Invalid entry.");
                isMonthCorrect = false;
                continue;
            }
            date = LocalDate.of(year, month, 1);
            isMonthCorrect = true;
        }
        //loop to enter day
        boolean isDayCorrect = false;
        int day = 0;
        while (!isDayCorrect) {
            System.out.println("Please enter BootCamp " + bootcamp.getName() + " " + str + " Day in an Integer Number (1-31): ");
            // check for integer
            if (!sc.hasNextInt()) {
                System.out.println("Only integer numbers are allowed. ");
                isDayCorrect = false;
                sc.next();
                continue;
            }
            day = sc.nextInt();
            //check for valid range 
            if ((day < 1) || (day > 31)) {
                System.out.print("Invalid entry.");
                isDayCorrect = false;
                sc.next();
                continue;
            }
            //check for 31 depending on startmonth:
            if ((day == 31) && ((month == 4) || (month == 6) || (month == 9))) {
                System.out.print("Month " + month + " only has 30 days!");
                isDayCorrect = false;
                continue;
            }
            //check for february 28 or 29
            boolean isLeapYear = date.isLeapYear();
            if ((day >= 29) && (month == 2) && (!isLeapYear)) {
                System.out.print("February " + year + " cannot have more than 28 days!");
                isDayCorrect = false;
                continue;
            }
            updatedDate = date.withDayOfMonth(day);
            DayOfWeek dayOfWeek = updatedDate.getDayOfWeek();
            String text = dayOfWeek + ", " + updatedDate.format(formatDate);
            isDayCorrect = true;
        }
        return updatedDate;
    }

    public static boolean isValidDuration(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            return false;
        }
        return true;
    }

    public static BootCamp addBootcamp() {
        BootCamp bootcamp = null;
        boolean isNameCorrect = false;
        while (!isNameCorrect) {
            System.out.println("Please enter BootCamp number " + bootcampNumber + " Name: ");
            String name = sc.next();
            // control for all alphabet letters only
            if (!containsOnlyAlphabet(name)) {
                System.out.println("Only alphabet Characters are allowed.");
                isNameCorrect = false;
                continue;
            } else {
                bootcamp = new BootCamp();
                bootcamp.setName(name);
                isNameCorrect = true;
            }
        }
        //loop to enter dates
        boolean areDatesOk = false;
        while (!areDatesOk) {
            LocalDate startDate = enterDate("Start", bootcamp);
            LocalDate endDate = enterDate("End", bootcamp);
            //check if duration is ok
            if (!isValidDuration(startDate, endDate)) {
                System.out.println("End date cannot be BEFORE the start date! Please re enter. ");
                areDatesOk = false;
                continue;
            }
            bootcamp.setStartingDate(startDate);
            bootcamp.setEndingDate(endDate);
            Period period = Period.between(startDate, endDate);
            bootcamp.setPeriod(period);
            areDatesOk = true;
        }
        BootCamp.printBootCamp(bootcamp);
        return bootcamp;
    }

    public static void create(int number) {
        System.out.println("Welcome! In this program you will be asked to create " + number + " different Bootcamp courses by entering their name(title), "
                + "staritng date and ending date.");
        while (bootcampNumber < number + 1) {
            BootCamp newBootCamp = addBootcamp();
            bootcamps.add(newBootCamp);
            bootcampNumber++;
        }
        System.out.println("You successfully entered the following Bootcamps: ");
        for (BootCamp b : bootcamps) {
            BootCamp.printBootCamp(b);
        }
    }
}
