import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"J","E","L","D","K","A","O"};
        DynamicStringArray dsa = new DynamicStringArray(strings);
        for (int i = 0; i < dsa.getStringArr().length; i++) {
            System.out.print(dsa.getStringArr()[i]);
        }
        dsa.sort(Sort.ASC);
        System.out.println();
        for (int i = 0; i < dsa.getStringArr().length; i++) {
            System.out.print(dsa.getStringArr()[i]);
        }
        dsa.sort(Sort.DESC);
        System.out.println();
        for (int i = 0; i < dsa.getStringArr().length; i++) {
            System.out.print(dsa.getStringArr()[i]);
        }
    }
}
