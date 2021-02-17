package javaStart.task42_Optional.lesson;


import java.util.Optional;

public class PersonTest {
    public static void main(String[] args) {
        PersonDatabase db = new PersonDatabase();
        db.add(new Person(1, "Jan", "Kowalski"));
        db.add(new Person(2, "Karol", "Zawadzki"));
        db.add(new Person(3, "Bartosz", "Abacki"));
        db.add(new Person(4, "Ania", "Walczak"));

        Optional<Person> optionalPerson1 = db.findById(2);
        if (optionalPerson1.isPresent()) {
            System.out.println(optionalPerson1.get().getLastName());
        }

        optionalPerson1.ifPresent(PersonTest::printLastName);

        optionalPerson1.ifPresent(person -> System.out.println(person.getLastName()));

        Optional<Person> optionalPerson2 = db.findById(55);
        if (optionalPerson2.isPresent()) {
            Person person2 = optionalPerson2.get();
            System.out.println(person2.getLastName());
        } else {
            System.out.println("Brak obiektu o wskazanym id");
        }

        optionalPerson2.ifPresent(person -> System.out.println(person.getLastName()));
        //metoda ifPresent() zabezpiecza aby wyrażenie lambda się nie wykonało i nie został rzucony wyjątek
        //NullPointException

        optionalPerson2.ifPresentOrElse(
                person -> System.out.println(person.getLastName()),
                () -> System.out.println("Brak obiektu o wskazanym id")
        );

        optionalPerson2.ifPresentOrElse(
                PersonTest::printLastName,
                PersonTest::printNoObject
        );

        String personByLastName = db.findPersonByLastName(6);
        System.out.println(personByLastName);

    }

    private static void printLastName(Person person) {
        System.out.println(person.getLastName());
    }

    private static void printNoObject() {
        System.out.println("Brak obiektu o wskazanym id");
    }
}
