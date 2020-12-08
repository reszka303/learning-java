package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.*;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

    public Item createPerson() {

        printer.printLine("First name");
        String firstName = getName();
        printer.printLine("Second name");
        String secondName = getName();
        printer.printLine("Pesel number");
        long id = getId();
//        BigInteger id = getId();
        printer.printLine("Place of birth");
        String placeBirth = getName();
        printer.printLine("Gender");
        char gender = getGender();

        return new Item(firstName, secondName, id, placeBirth, gender);
    }

    public Item removePerson() {
        printer.printLine("Pesel number");
        long id = getId();

        return new Item(id);
    }

    public Item createCar() {
        printer.printLine("Mark:");
        String mark = getName();
        printer.printLine("Model:");
        String model = input.nextLine();
        printer.printLine("Vin");
        String vin = getVin();
        printer.printLine("Engine capacity (ccm3):");
        int engineCapacity = getCapacity();
        printer.printLine("Damaged? true/false");
        boolean damage = getDamage();

        return new Item(mark, model, vin, engineCapacity, damage);
    }

    public Item removeCar() {
        printer.printLine("Vin");
        String vin = getVin();

        return new Item(vin);
    }

    private String getName() {
        boolean nameOk = false;
        String name = null;

        while (!nameOk) {
            try {
                name = checkLetters();
                nameOk = true;
            } catch (LetterNotFoundException e) {
                e.getMessage();
            }
        }
        return name;
    }

    private String checkLetters() {
        String name;

        name = input.nextLine();
        if (name.matches("[a-zA-ZĄąĆćĘęŁłŃńÓóŚśŹźŻż\" \"'-]+")) {
            return name;
        } else {
            throw new LetterNotFoundException("Name" +
                    " must be letters only, try again");
        }
    }

    private long getId() {
        boolean idOk = false;
        long id = -1L;

        while (!idOk) {
            try {
                id = getIdNumber();
                idOk = true;
            } catch (IncorrectIdLengthException e) {
                e.getMessage();
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Id must be digits, try again");
            } finally {
                clearBuffer();
            }
        }
        return id;
    }

    private long getIdNumber() {
        long zero = 0;
        long digitsLength = 11;
        long id;

        id = input.nextLong();
        long idLength = String.valueOf(id).length();

        if (id < zero) {
            throw new PositiveNumberNotFoundException("Id must be positive, try again");
        } else if (idLength == digitsLength) {
            return id;
        } else if (idLength != digitsLength){
            throw new IncorrectIdLengthException("Id must be 11 characters, try again");
        }
        return id;
    }
    
    private char getGender() {
        boolean genderOk = false;
        char gender = ' ';

        while (!genderOk) {
            try {
                gender = getCharacter();
                genderOk = true;
            } catch (IncorrectCharacterException e) {
                e.getMessage();
            } catch (StringIndexOutOfBoundsException e) {
                printer.printLineError("Character can't be empty, try again");
            }
        }
        return gender;
    }

    private char getCharacter() {
        char male = 'm';
        char female = 'f';
        char gender = ' ';

        gender = input.nextLine().charAt(0);
        if (gender == male || gender == female) {
            return gender;
        } else {
            throw new IncorrectCharacterException("Enter 'm' or 'f'");
        }
    }

    private String getVin() {
        boolean vinOk = false;
        String vin = null;

        do {
            try {
                vin = checkLength();

                if (vin.matches("^[a-zA-Z0-9]+$"))
                vinOk = true;

                if (!vin.matches("^[a-zA-Z0-9]+$"))
                    throw new LettersAndDigitsException("Vin must be " +
                            "letters and digits, no negative, no double, try again");
            } catch (IncorrectStringLengthException e) {
                e.getMessage();
            } catch (LettersAndDigitsException e) {
                e.getMessage();
            }
        } while (!vinOk);
        return vin;
    }

    private String checkLength() {
        int lengthVin = 17;
        String vin = input.nextLine();

        if (vin.length() == lengthVin) {
            return vin;
        } else if (vin.length() != lengthVin) {
            throw new IncorrectStringLengthException("Vin number must be 17 characters," +
                    " try again");
        }
        return vin;
    }

    private int getCapacity() {
        boolean capacityOk = false;
        int capacity = -1;

        while (!capacityOk) {
            try {
                capacity = getDigit();
                capacityOk = true;
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Capacity must be digits, try again");
            } finally {
                clearBuffer();
            }
        }
        return capacity;
    }

    private int getDigit() {
        int zero = 0;
        int capacity;

        capacity = input.nextInt();

        if (capacity > zero) {
            return capacity;
        } else if (capacity < zero) {
            throw new PositiveNumberNotFoundException("Capacity must be positive, try again");
        }
        return capacity;
    }

    private boolean getDamage() {
        boolean damagedOk = false;
        boolean damaged = false;

        while (!damagedOk){
            try {
                damaged = input.nextBoolean();
                if (damaged) {
                    damagedOk = true;
                } else {
                    damagedOk = true;
                }
            } catch (InputMismatchException e) {
                printer.printLineError("Invalid input, try again");
            } finally {
                clearBuffer();
            }
        }
        return damaged;
    }

    public int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    private String clearBuffer() {
        return input.nextLine();
    }

    public void close() {
        input.close();
    }



    //    private BigInteger getId() {
//        boolean idOk = false;
//        BigInteger id = new BigInteger("-1");
//
//        while (!idOk) {
//            try {
//                id = getNumber();
//                idOk = true;
//             } catch (IncorrectIdLengthException e) {
//                e.getMessage();
//            } catch (PositiveNumberNotFoundException e) {
//                e.getMessage();
//            } catch (InputMismatchException e) {
//                printer.printLineError("Id must be digits, try again");
//            } finally {
//                clearBuffer();
//            }
//        }
//        return id;
//    }

//    private BigInteger getNumber() {
//        int sizeId = 11;
//        int negative = -1;
//        BigInteger id;
//
//        id = input.nextBigInteger();
//        if (id.toString().length() == sizeId) {
//            return id;
//        } else if (id.signum() == negative){
//            throw new PositiveNumberNotFoundException("Id must be positive, try again");
//        } else if (id.toString().length() != sizeId) {
//            throw new IncorrectIdLengthException("Id must be 11 characters, try again");
//        }
//        return id;
//    }

    //    private String getSex() {
//        boolean sexOk = false;
//        String sex = null;
//
//        while (!sexOk) {
//            try {
//                sex = checkSex();
//                sexOk = true;
//            } catch (IncorrectCharacterException e) {
//                e.getMessage();
//            }
//        }
//        return sex;
//    }
//
//    private String checkSex() {
//        String male = "m";
//        String female = "f";
//        String sex = null;
//
//        if (sex.equals(male) || sex.equals(female))  {
//            return sex;
//        } else {
//            throw new IncorrectCharacterException("Enter 'm' or 'f'");
//        }
//    }
}
