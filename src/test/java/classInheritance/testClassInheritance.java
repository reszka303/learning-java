package classInheritance;

import kodilla.modul1.classInheritance.Dog;
import org.junit.Test;

public class testClassInheritance {
    @Test
    public void displayingAnimalMethods() {
        //Given - Arrange
        Dog dog1 = new Dog();

        //When - Act
        dog1.drink("Ami");
        dog1.eat("Ami");
    }
}
