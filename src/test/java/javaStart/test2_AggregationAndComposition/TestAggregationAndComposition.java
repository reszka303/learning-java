package javaStart.test2_AggregationAndComposition;

import javaStart.task2_AggregationAndComposition.BankAccount;
import javaStart.task2_AggregationAndComposition.Credit;
import javaStart.task2_AggregationAndComposition.Person;
import javaStart.task2_AggregationAndComposition.PlaceOfResidence;
import org.junit.Test;

public class TestAggregationAndComposition {
    @Test
    public void AggregationAndComposition() {
        Person person1 = new Person();
        PlaceOfResidence placeOfResidence1 = new PlaceOfResidence();
        BankAccount bankAccount1 = new BankAccount();
        Credit credit1 = new Credit();

        person1.name = "John";
        person1.surname = "Watson";
        person1.idNumber = 81062812189L;

        placeOfResidence1.street = "Forest Hills";
        placeOfResidence1.streetNumber = "16/4";
        placeOfResidence1.postcode = "A0B 0B1";
        placeOfResidence1.place = "Cavendish";

        person1.placeOfResidence = placeOfResidence1;

        bankAccount1.owner = person1;
        bankAccount1.balance = 12_500.69;

        credit1.borrower = person1;
        credit1.cashBorrowed = 2_500.00;
        credit1.cashReturned = 550.00;
        credit1.interestsRate = 0.05;
        credit1.termMonths = 12;

        System.out.println("1.Person");
        System.out.println("Name: " + person1.name);
        System.out.println("Surname: " + person1.surname);
        System.out.println("Id Number: " + person1.idNumber);
        System.out.println("2.Place of residence");
        System.out.println("Street: " + person1.placeOfResidence.street);
        System.out.println("Street number: " + person1.placeOfResidence.streetNumber);
        System.out.println("Postcode: " + person1.placeOfResidence.postcode);
        System.out.println("Place: " + person1.placeOfResidence.place);
        System.out.println("3.Bank account");
        System.out.println("Balance in the bank account: " + bankAccount1.balance);
        System.out.println("4. Credit");
        System.out.println("Cash borrowed: " + credit1.cashBorrowed);
        System.out.println("Cash returned: " + credit1.cashReturned);
        System.out.println("Interests rate : " + credit1.interestsRate);
        System.out.println("Term months: " + credit1.termMonths);
    }
}
