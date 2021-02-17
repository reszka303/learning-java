package javaStart.task42_Optional.exercise1.Me;

import java.util.Optional;
import java.util.Scanner;

class ContactApp {
    public static void main(String[] args) {
        Optional<ContactManager> contactManager = ContactReader.readFile("contacts.csv");
        Optional<Contact> contactByEmail = getContact(contactManager);
        System.out.println("Kontakt o wskazanym adresie email:");
        printInfo(contactByEmail);
    }

    private static Optional<Contact> getContact(Optional<ContactManager> contactManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj adres email do wyszukania kontaktu:");
        String email = scanner.nextLine();
        return contactManager.flatMap(manager -> manager.findByEmail(email));
    }

    private static void printInfo(Optional<Contact> contactByEmail) {
        contactByEmail.ifPresentOrElse(
                ContactApp::getShortInfo,
                ContactApp::noContactWithGivenEmailInfo
        );
    }

    private static void getShortInfo(Contact contact) {
        System.out.println(contact.getShortInfo());
    }

    private static void noContactWithGivenEmailInfo() {
        System.out.println("Brak kontaktu o wskazanym adresie");
    }
}
