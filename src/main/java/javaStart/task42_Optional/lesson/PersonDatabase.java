package javaStart.task42_Optional.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDatabase {
    private List<Person> people = new ArrayList<>();

    public void add(Person person) {
        if (person == null)
            throw new NullPointerException("Cannot add null reference");
        findById(person.getId()).ifPresent(p -> {
                    throw new IllegalArgumentException("Object with such id already exists");
                });
        people.add(person);
    }

    Optional<Person> findById(int id) {
        for (Person person : people) {
            if (person.getId() == id)
                return Optional.of(person);
        }
        return Optional.empty();
    }

//    String findPersonByLastName(int id) {
//        Optional<Person> findById = findById(id); //Optional<Person>
//        Optional<String> lastNameOptional = findById.map(person -> person.getLastName());//Optional<String>
//        if (lastNameOptional.isPresent())
//        return lastNameOptional.get();
//            return "Anonim";
//    }

    String findPersonByLastName(int id) {
        return findById(id) //Optional<Person>
        .map(Person::getLastName) //Optional<String>
        .orElse("Anonim");
    }
}

