package de.ait;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Jack", 10, 30, 130);
        int weight = person.getWeight();
        System.out.println(weight);
        System.out.println(person);
        Person mike = Person.builder()
                .name("Mike")
                .height(178)
                .age(45)
                .build();
        System.out.println(mike);
    }
}