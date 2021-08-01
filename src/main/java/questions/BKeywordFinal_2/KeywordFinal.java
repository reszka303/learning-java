package questions.BKeywordFinal_2;

public class KeywordFinal {
    public static void main(String[] args) {
        final int numberFinal = 4;
        System.out.println(numberFinal);

        int number = 5;
        int result = increaseValueBy10(number);
        System.out.println(number);
        System.out.println(result);

        A a = new A();
        a.myMethod();

        B b = new B();
        b.myMethod();
    }

    static int increaseValueBy10(int x) {
        x = x + 10;
        return x;
    }
}

class A {
    final void myMethod() {
        System.out.println("AAA");
    }
}

class B extends A {
//    @Override
//    void myMethod() { //błąd  cannot override, overridden method is final
//        System.out.println("BBB");
//    }
}

final class C{
}

//class D extends C { //błąd cannot inherit from final
//}
