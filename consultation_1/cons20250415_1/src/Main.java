import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> list1 = new ArrayList<>();
        Person person1 = new Person("Person1", 22);
        Person person2 = new Person("Person2", 23);
        Person person3 = new Person("Person3", 24);
        Person person4 = new Person("Person2", 25);
        Person person5 = new Person("Person5", 26);
        Person person6 = new Person("Person6", 27);

        list1.add(person1);
        list1.add(person2);
        list1.add(person3);
        list1.add(person4);
        list1.add(person5);
        list1.add(person6);
        String targetName = "Person2";
        findName(list1, targetName);
    }


    public static void findName(List<Person> list, String targetName) {
        List<Person> result = list
                .stream()
                .filter(person -> person.getName()
                .equals(targetName))
                .toList();
        if (result.isEmpty()) {
            System.out.println("Совпадений нет");
        } else {
            System.out.println("Найдено совпадений: " + result.size());
            System.out.println(result);
        }
    }
}