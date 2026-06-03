import java.util.List;

record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {

        Person p1 = new Person("Ravi", 20);
        Person p2 = new Person("Anjali", 17);
        Person p3 = new Person("Kiran", 25);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = List.of(p1, p2, p3);

        System.out.println("\nPeople age 18 and above:");

        people.stream()
              .filter(person -> person.age() >= 18)
              .forEach(System.out::println);
    }
}