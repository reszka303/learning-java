package javaStart.task19_ObjectMethods.lesson;

public class School {
    public static void main(String[] args) {
        Student student1 = new Student("Jan Kowalski", 25);
        Student student2 = new Student("Jan Kowalski", 25);
        System.out.println("student1 == student2");
        System.out.println(student1 == student2);
        System.out.println("student1.equals(student2)");
        System.out.println(student1.equals(student2));

        System.out.println();
        System.out.println("Adres obietku na stercie, która jest wskazywana przez referencję 'student1' na stosie:");
        System.out.println(student1);
        System.out.println();
        System.out.println("Adres obietku na stercie, która jest wskazywana przez referencję 'student2' na stosie:");
        System.out.println(student2);
        System.out.println();
        System.out.println("hashcode student1: " + student1.hashCode());
        System.out.println("hashcode student2: " +student2.hashCode());
    }

    //domyślna implementacja metody equals przez nadrzędną klasę Object
    //słowo this jest referencją na której wywołujemy tę metodę w tym przypadku student1
    //natomiast obj jest argumentem metody equals, w naszym przypadku student2
    //w metodzie jest wykorzystywany operator porównania
    //dlatego do strukturalnego porówniania typów obiektowych jest on nie wystarczający
    //aby metoda equals działała poprawnie trzeba ją nadpisać
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
