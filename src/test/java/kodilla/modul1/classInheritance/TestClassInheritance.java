package kodilla.modul1.classInheritance;

import org.junit.Test;

public class TestClassInheritance {
    @Test
    public void displayingAnimalMethods() {
        //Given - Arrange
        Dog dog1 = new Dog();

        //When - Act
        dog1.drink("Ami");
        dog1.eat("Ami");
    }
}
