/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-30 10:36
 **/
public class Test {

    public static void main(String[] args) {
        // Object initialization
        Double ob1 = new Double("10.20");
        Double ob2 = new Double("20.20");

        // Display ob1,ob2 values
        System.out.println("ob1:" + ob1);
        System.out.println("ob2:" + ob2);

        // It represents string of this Double object
        String value1 = ob1.toString();

        // It represents string of the given double parameter
        String value2 = Double.toString(ob2);

        // Display result values
        System.out.println("ob1.toString(): " + value1);
        System.out.println("Double.toString(ob2): " + value2);

    }
}
