public class TypeCastingExample {
    public static void main(String[] args) {

        // Double to Int (Narrowing)
        double d = 25.89;
        int i = (int) d;

        System.out.println("Double value: " + d);
        System.out.println("After casting to int: " + i);

        // Int to Double (Widening)
        int num = 50;
        double converted = num;

        System.out.println("Integer value: " + num);
        System.out.println("After casting to double: " + converted);
    }
}