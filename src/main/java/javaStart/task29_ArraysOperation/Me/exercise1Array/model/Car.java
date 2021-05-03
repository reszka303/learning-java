package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;

public class Car extends VehicleEngine {
    private PersonDatabase personDatabase = new PersonDatabase();
    private int vin;
    private int initialCapacity = 0;
    private Car[] cars = new Car[initialCapacity];

    public Car(String mark, String model, int engineCapacity, String fuel, int vin) {
        super(mark, model, engineCapacity, fuel);
        this.vin = vin;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return getMark() + " " + getModel() + " " + getEngineCapacity() + "cm3 " + getFuel() + " " + vin;
    }

//    public Car[] add(Car car) {
//        int capacity = cars.length;
//        Car[] copyCars = new Car[capacity + 1];
//        for (int i = 0; i < capacity; i++) {
//            copyCars[i] = cars[i];
//        }
//        copyCars[capacity] = car;
//        if (cars.length >= 1){
//            checkDuplicate(car);
//        }
//        cars = copyCars;
//        return cars;
//    }

        private void checkDuplicate(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getVin() == car.getVin()) {
                throw new DuplicateException("There is already the car with the same id");
            }
        }
    }

//    public Car[] remove(int vin) {
//        int capacity = cars.length;
//        int verifyId = personDatabase.checkId(vin);
//        personDatabase.checkIfException(verifyId);
//        cars = toNull(verifyId, capacity);
//        cars = nullToLastIndex(capacity);
//        cars = removeNull();
//        return cars;
//    }

    private Car[] toNull(int id, int capacity) {
        Car[] copyCars = new Car[capacity- 1];
        for (int i = 0; i < capacity; i++) {
            if (cars[i].getVin() != id) {
                copyCars[i] = cars[i];
            }
        }
        return copyCars;
    }

    private Car[] nullToLastIndex(int capacity) {
        Car[] copyCars = new Car[capacity -1];
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            if (cars[i] == null) {
                copyCars[index++] = cars[i];
            }
        }
        return copyCars;
    }

    private Car[] removeNull() {
        int capacity = cars.length;
        Car[] copyCars = new Car[capacity - 1];
        for (int i = 0; i < capacity; i++) {
            copyCars[i] = cars[i];
        }
        return copyCars;
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
