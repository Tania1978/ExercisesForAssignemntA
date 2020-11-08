package ExercisesAssignment1;

import java.util.ArrayList;

public class Person {

    private String name;
    private int age;
    private ArrayList<Pet> pets;
    static int count = 0;

    public Person() {
        this.pets = new ArrayList<Pet>();
        count++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setArrayList(ArrayList<Pet> finalPets) {
        if (this.pets != null) {
            this.pets = finalPets;
        } else {
            System.out.println("Did not setArrayList");
        }
    }

    public static void printPerson(Person person) {
        if(person.getPets().isEmpty()){
        System.out.println(person.getName() + ":  Age " +  person.getAge() +  ", No Pets.");
    } else {
            System.out.println(person.getName() + ":  Age " +  person.getAge() +  ", Has: " + person.getPets() + ".");
        }
}
}