package javaStart.task29_ArraysOperation.Me.exercise1Array.io.file;


import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DataReadException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DataWriteException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.*;

import java.io.*;

public class CsvFileManager implements FileManager  {
    private static final String PERSONS = "D:\\INNE\\Programowanie\\Projects\\learning\\ArraysOperations" +
            "\\exercise1\\persons.txt";
    private static final String CARS = "D:\\INNE\\Programowanie\\Projects\\learning\\ArraysOperations" +
            "\\exercise1\\cars.txt";

//    @Override
//    public DatabaseManager read() {
//        DatabaseManager databaseManager = new DatabaseManager();
//        readPersons(databaseManager);
//        readCars(databaseManager);
//        return databaseManager;
//    }

//    @Override
//    public void write(DatabaseManager databaseManager) {
//        writePersons(databaseManager);
//        writeCars(databaseManager);
//    }

    @Override
    public <T> T read() {
        DatabaseManager databaseManager = new DatabaseManager();
        readPersons(databaseManager);
        readCars(databaseManager);
        return (T) databaseManager;
    }

    @Override
    public <T> void write(T t) {
        writePersons((DatabaseManager) t);
        writeCars((DatabaseManager) t);
    }

    public DatabaseManager readPersons(DatabaseManager databaseManager) {
        try (var reader = new BufferedReader(new FileReader(PERSONS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = personToTxt(line);
                databaseManager.getPersonDatabase().add(person);
            }
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + PERSONS);
        } catch (IOException e) {
            throw new DataReadException("Error read file " + PERSONS);
        }
        return databaseManager;
    }

    public DatabaseManager readCars(DatabaseManager databaseManager) {
        try (var reader = new BufferedReader(new FileReader(CARS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Car car = carToTxt(line);
                databaseManager.getCarDatabase().add(car);
            }
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + CARS);
        } catch (IOException e) {
            throw new DataReadException("Error read file " + CARS);
        }
        return databaseManager;
    }

    private Person personToTxt(String text) {
        String[] array = text.split(";");
        String firstName = array[0];
        String secondName = array[1];
        int id = Integer.parseInt(array[2]);
        return new Person(firstName, secondName, id);
    }

    private Car carToTxt(String text) {
        String[] array = text.split(";");
        String mark = array[0];
        String model = array[1];
        int engineCapacity = Integer.parseInt(array[2]);
        String fuel = array[3];
        int vin = Integer.parseInt(array[4]);
        return new Car(mark, model, engineCapacity, fuel, vin);
    }

    public void writePersons(DatabaseManager databaseManager) {
        Person[] persons = databaseManager.getPersonDatabase().getPersons();
        writeToCsv(persons, PERSONS);
    }

    public void writeCars(DatabaseManager databaseManager) {
        Car[] cars = databaseManager.getCarDatabase().getCars();
        writeToCsv(cars, CARS);
    }

    public <T extends CsvConvertible> void writeToCsv(T[] t, String fileName) {
        try (var writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T element : t) {
                writer.write(element.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DataWriteException("Data write error into file " + fileName);
        }
    }
}
