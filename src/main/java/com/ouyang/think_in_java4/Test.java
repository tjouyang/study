package com.ouyang.think_in_java4;
import java.lang.reflect.Array;
import java.util.*;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = Test.rand.nextInt(100);
    static {
        System.out.println("init Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 47;
    static {
        System.out.println("init Initable2");
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        System.out.println(integers.getClass() == strings.getClass());
        Object o = Array.newInstance(String.class, 10);
        if (o instanceof String[]) {
            System.out.println(Arrays.toString((String[])o));
        }
        System.out.println(Objects.toString(o));
    }

}

public class Test {

    enum Week {Sunday, Friday;}

    EnumSet<Week> set = EnumSet.allOf(Week.class);

    public static final String str = "haha";

    public static boolean isOk() {
        return true;
    }

    public static Random rand = new Random();
    public static void main(String[] args) {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println("-------------");
        System.out.println(Initable2.staticNonFinal);
    }

}
