package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.CheckDuplicateException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.NoIndicatedItemException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemDatabase implements Serializable {
    private List<Item> persons = new ArrayList<>();
    private List<Item> cars = new ArrayList<>();

    public List<Item> getPerson() {
        return persons;
    }

    public void addPerson(Item person) {
        checkDuplicatePerson(person);
        persons.add(person);
    }

    private void checkDuplicatePerson(Item item) {
        for (Item itemInCollection : persons) {
            if (item.getI().equals(itemInCollection.getI())) {
                throw new CheckDuplicateException("There is the person " +
                        "with the same id number anymore in the database");
            }
        }
    }

    public boolean removePerson(Item item) {
        boolean removeOk = false;

        for (int i = 0; i < persons.size(); i++) {
            if (item.equals(persons.get(i))) {
                persons.remove(item);
                removeOk = true;
            } else {
                throw new NoIndicatedItemException("No indicated person");
            }
        }
        return removeOk;
    }

    public List<Item> getCars() {
        return cars;
    }

    public void addCar(Item car) {
        checkDuplicateCars(car);
        cars.add(car);
    }

    private void checkDuplicateCars(Item car) {
        for (Item carElement : cars) {
            if (car.getI().equals(carElement)) {
                throw new CheckDuplicateException("There is the car" +
                        "with the same vin number anymore in the database");
            }
        }
    }

    public boolean removeCar(Item car) {
        boolean removeOk = false;

        for (int i = 0; i < cars.size(); i++) {
            if (car.getI().equals(cars.get(i).getI())) {
                cars.remove(car);
                removeOk = true;
            } else {
                throw new NoIndicatedItemException("No indicated car");
            }
        }
        return removeOk;
    }
}
