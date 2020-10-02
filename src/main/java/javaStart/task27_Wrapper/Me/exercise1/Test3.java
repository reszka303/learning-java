package javaStart.task27_Wrapper.Me.exercise1;

import java.math.BigDecimal;

public class Test3 {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("921229392299229.2922929292920000");
        int fractionCount = d.scale();
        System.out.println(fractionCount);
        int wholeCount = (int) (Math.ceil(Math.log10(d.longValue())));
        System.out.println(wholeCount);
    }
}
