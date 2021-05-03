package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NumberNotFoundException;

public class CarDatabase implements Database {
    private final int initialCapacity = 0;
    private Car[] cars = new Car[initialCapacity];

    public Car[] getCars() {
        return cars;
    }

    @Override
    public <T> T[] add(T t) {
        int capacity = cars.length;
        Car[] copyCars = new Car[capacity + 1];
        for (int i = 0; i < capacity; i++) {
            copyCars[i] = cars[i];
        }
        copyCars[capacity] = (Car) t;
        if (cars.length >= 1){
            checkDuplicate((Car) t);
        }
        cars = copyCars;
        return (T[]) cars;
    }

    private void checkDuplicate(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getVin() == car.getVin()) {
                throw new DuplicateException("There is already the car with the same id");
            }
        }
    }

    @Override
    public <T> T[] remove(int vin) {
        int capacity = cars.length;
        int vinVerify = checkId(vin);
        checkIfException(vinVerify);
        cars = toNull(capacity, vin);
        cars = nullToLastIndex(capacity);
        cars = removeNull(capacity);
        return (T[]) cars;
    }

    private Car[] toNull(int capacity, int vin) {
        Car[] carsWithNull = new Car[capacity];
        for (int i = 0; i < capacity; i++) {
            if (cars[i].getVin() != vin) {
                carsWithNull[i] = cars[i];
            }
        }
        return carsWithNull;
    }

    private Car[] nullToLastIndex(int capacity) {
        int index = 0;
        Car[] carsWithNullInLastIndex = new Car[capacity];
        for (int i = 0; i < capacity; i++) {
            if (cars[i] != null) {
                carsWithNullInLastIndex[index++] = cars[i];
            }
        }
        return carsWithNullInLastIndex;
    }

    private Car[] removeNull(int capacity) {
        int resize = capacity - 1;
        Car[] carsNoNull = new Car[resize];
        for (int i = 0; i < resize; i++) {
            carsNoNull[i] = cars[i];
        }
        return carsNoNull;
    }

    private int checkId(int vin) {
        int capacity = cars.length;
        int vinVerify = 0;
        for (int i = 0; i < capacity; i++) {
            if (cars[i].getVin() == vin) {
                vinVerify++;
            }
        }
        return vinVerify;
    }

    private int checkIfException(int vinVerify) {
        if (vinVerify == 0) {
            throw new NumberNotFoundException("There is no cars with given vin");
        }
        return vinVerify;
    }
}
