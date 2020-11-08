package ExercisesAssignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Family {
    
    static Scanner sc = new Scanner(System.in);
    
    public static boolean isInteger(String str) {
        char[] stringToCharArray = str.toCharArray();
        for (char c : stringToCharArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
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
    
    public static Person addPersonToFamily(String name) {
        int personNumber = 1;
        Person person = new Person();
        boolean toContinue = true;
        int age = 0;
        while (toContinue) {
            if (!containsOnlyAlphabet(name)) {
                System.out.println("Only alphabet characters are allowed when entering a name:");
                name = sc.next();
                toContinue = true;
                continue;
            }
            person.setName(name);
            System.out.println("Please enter the age of " + person.getName() + " as an Integer number between 0 (for babies under the age of 1) and 110: ");
            if (!sc.hasNextInt()) {
                System.out.println("Only integer numbers are allowed. ");
                toContinue = true;
                sc.next();
                continue;
            }
            age = sc.nextInt();
            if ((age > 110) || (age < 0)) {
                System.out.println("A valid age is between 0-110 years.");
                toContinue = true;
                continue;
            }
            person.setAge(age);
            System.out.println("The age of " + person.getName() + " is " + person.getAge() + ".");
            toContinue = false;
        }
        return person;
    }
    
    public static ArrayList<Pet> addPetsToPerson(Person person) {
        ArrayList<Pet> personsPets = new ArrayList<>();
        boolean petContinue = true;
        while (petContinue) {
            System.out.println("Please enter the name of " + person.getName() + "'s" + " pet: ");
            String petName = sc.next();
            if (!containsOnlyAlphabet(petName)) {
                System.out.println("Only alphabet characters are allowed when entering a name.");
                petContinue = true;
                continue;
            }
            Pet pet = new Pet(petName);
            personsPets.add(pet);
            person.setArrayList(personsPets);
            ArrayList<String> allowedPets = new ArrayList(Arrays.asList("Dog", "Cat", "Hampster", "Bunny", "Lizard", "Tortoise", "Snake", "Parrot", "Bird", "Horse", "Monkey"));
            Collections.sort(allowedPets);
            
            System.out.println("What type of animal is " + pet.getNickname() + " ?");
            boolean isTypeCorrect = false;
            int petTypeChoice = 0;
            while (!isTypeCorrect) {
                System.out.println(" Please choose one of the below available options. Enter the integer number indicated to declare your choice:   ");
                System.out.println("1 -Bird, 2 - Bunny, 3 - Cat, 4 - Dog, 5 - Hampster, 6 -Horse, 7- Lizard, 8 -Monkey, 9 - Parrot, 10 - Snake, 11 -Tortoise,12- pet type not listed");
                if (!sc.hasNextInt()) {
                    System.out.println("Only integer numbers are allowed. ");
                    isTypeCorrect = false;
                    sc.next();
                    continue;
                }
                petTypeChoice = sc.nextInt();
                switch (petTypeChoice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        String choice = allowedPets.get(petTypeChoice - 1);
                        pet.setType(choice);
                        System.out.println(pet.getNickname() + " is a " + choice);
                        isTypeCorrect = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        isTypeCorrect = false;
                        petContinue = false;
                }
            }
            
            boolean hasMorePets = true;
            while (hasMorePets) {
                System.out.println("Does " + person.getName() + " have more pets?");
                System.out.println("Please enter 0: NO or 1: YES ");
                String morePets = sc.next();
                boolean isInteger = isInteger(morePets);
                if (!isInteger) {
                    System.out.println("Invalid Choice. ");
                    hasMorePets = true;
                    continue;
                }
                int intPetChoice = Integer.parseInt(morePets);
                switch (intPetChoice) {
                    case 0:
                        System.out.println("Thank you!");
                        System.out.println(person.getName() + "'s pets are " + personsPets.toString());
                        hasMorePets = false;
                        petContinue = false;
                        break;
                    case 1:
                        hasMorePets = false;
                        petContinue = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        hasMorePets = false;
                        petContinue = false;
                }
            }
        }
        return personsPets;
    }
    
    public static int setSizeOfFamily() {
        int sizeOfFamily = 0;
        boolean toContinue = true;
        System.out.println("Welcome! In this program you will be asked to enter your family details. ");
        System.out.println("How many members are in your family?");
        
        while (toContinue) {
            System.out.println("You must enter at least three persons. ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter an integer number: ");
                sc.next();
                continue;
            }
            sizeOfFamily = sc.nextInt();
            if (sizeOfFamily < 3) {
                System.out.print("Number too small.");
                continue;
            }
            break;
        }
        return sizeOfFamily;
    }
    
    public static void printFamilyDetails() {
        int familySize = Family.setSizeOfFamily();
        int personNumber = 1;
        ArrayList<Person> family = new ArrayList<>();
        
        while (personNumber < (familySize + 1)) {
            System.out.println("Please enter the name of person " + personNumber + " of your family: ");
            String name = sc.next();
            Person person = Family.addPersonToFamily(name);
            family.add(person);
            System.out.println("Does " + person.getName() + " have pets?");
            ArrayList<Pet> pets = new ArrayList<>();
            boolean hasPets = true;
            while (hasPets) {
                System.out.println("Please enter 0: NO or 1: YES ");
                String petsChoice = sc.next();
                boolean isInteger = isInteger(petsChoice);
                if (!isInteger) {
                    System.out.println("Invalid Choice. ");
                    hasPets = true;
                    continue;
                }
                int intPetChoice = Integer.parseInt(petsChoice);
                switch (intPetChoice) {
                    case 0:
                        System.out.println(person.getName() + " does not have any pets. ");
                        personNumber++;
                        hasPets = false;
                        break;
                    case 1:
                        pets = addPetsToPerson(person);
                        person.setArrayList(pets);
                        hasPets = false;
                        personNumber++;
                }
            }
        }
        System.out.println("Your Family: ");
        for (Person p : family) {
            Person.printPerson(p);
        }
    }
}
