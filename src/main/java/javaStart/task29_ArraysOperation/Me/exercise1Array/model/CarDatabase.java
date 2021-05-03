package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NumberNotFoundException;

import java.util.Arrays;

public class CarDatabase {
    private int initialCapacity = 0;
    private Car[] cars = new Car[initialCapacity];

    public Car[] getCars() {
        return cars;
    }

    public Car[] add(Car car) {
        int capacity = cars.length;
        Car[] copyCars = new Car[capacity + 1];
        for (int i = 0; i < capacity; i++) {
            copyCars[i] = cars[i];
        }
        copyCars[capacity] = car;
        if (cars.length >= 1){
            checkDuplicate(car);
        }
        cars = copyCars;
        return cars;
    }

    private void checkDuplicate(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getVin() == car.getVin()) {
                throw new DuplicateException("There is already the car with the same id");
            }
        }
    }

    public Car[] remove(int vin) {
        int capacity = cars.length;
        int verifyId = checkId(vin);
        checkIfException(verifyId);
        cars = toNull(capacity, vin);
        cars = nullToLastIndex(capacity);
        cars = removeNull(capacity);
        return cars;
    }

    private Car[] toNull(int capacity, int vin) {
        Car[] copyCars = new Car[capacity];
        for (int i = 0; i < capacity; i++) {
            if (cars[i].getVin() != vin) {
                copyCars[i] = cars[i];
            }
        }
        System.out.println("To null" + Arrays.toString(copyCars));
        return copyCars;
    }

    private Car[] nullToLastIndex(int capacity) {
        int index = 0;
        Car[] copyCars = new Car[capacity];
        for (int i = 0; i < capacity; i++) {
            if (cars[i] != null) {
                copyCars[index++] = cars[i];
            }
        }
        System.out.println("Null to last index" + Arrays.toString(copyCars));
        return copyCars;
    }

    private Car[] removeNull(int capacity) {
        int resize = capacity - 1;
        Car[] copyCars = new Car[resize];
        for (int i = 0; i < resize; i++) {
            copyCars[i] = cars[i];
        }
        System.out.println("Remove last index" + Arrays.toString(copyCars));
        return copyCars;
    }

    int checkId(int vin) {
        int size = cars.length;
        int idVerify = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getVin() == vin) {
                idVerify++;
            }
        }
        return idVerify;
    }

    int checkIfException(int idVerify) {
        if (idVerify == 0) {
            throw new NumberNotFoundException("There is no cars with given vin");
        }
        return idVerify;
    }



//    @Override
//    public <T> T[] add(T t) {
//        int capacity = cars.length;
//        Car[] copyCars = new Car[capacity + 1];
//        for (int i = 0; i < capacity; i++) {
//            copyCars[i] = cars[i];
//        }
//        copyCars[capacity] = (Car) t;
//        if (cars.length >= 1){
//            checkDuplicate((Car) t);
//        }
//        cars = copyCars;
//        return (T[]) cars;
//    }
//
//    private void checkDuplicate(Car car) {
//        for (int i = 0; i < cars.length; i++) {
//            if (cars[i].getVin() == car.getVin()) {
//                throw new DuplicateException("There is already the car with the same id");
//            }
//        }
//    }

//    @Override
//    public <T> T[] remove(int vin) {
//        int capacity = cars.length;
//        int verifyId = personDatabase.checkId(vin);
//        personDatabase.checkIfException(verifyId);
//        cars = toNull(verifyId, capacity);
//        cars = nullToLastIndex(capacity);
//        cars = removeNull();
//        return (T[]) cars;
//    }
//
//    private Car[] removeNull() {
//        int capacity = cars.length;
//        Car[] copyCars = new Car[capacity - 1];
//        for (int i = 0; i < capacity; i++) {
//            copyCars[i] = cars[i];
//        }
//        return copyCars;
//    }
//
//    private Car[] nullToLastIndex(int capacity) {
//        Car[] copyCars = new Car[capacity -1];
//        int index = 0;
//        for (int i = 0; i < capacity; i++) {
//            if (cars[i] == null) {
//                copyCars[index++] = cars[i];
//            }
//        }
//        return copyCars;
//    }
//
//    private <T> T[] toNull(int id, int capacity) {
//        Car[] copyCars = new Car[capacity- 1];
//        for (int i = 0; i < capacity; i++) {
//            if (cars[i].getVin() != id) {
//                copyCars[i] = cars[i];
//            }
//        }
//        return (T[]) copyCars;
//    }
}
