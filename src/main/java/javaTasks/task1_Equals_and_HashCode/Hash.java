package javaTasks.task1_Equals_and_HashCode;

public class Hash {
    public static void main(String[] args) {
        String s1 = "Aa";
        String s2 = "BB";
        System.out.println(s1.equals(s2));//false
        System.out.println(s1.hashCode());//2112
        System.out.println(s2.hashCode());//2112
    }
}
