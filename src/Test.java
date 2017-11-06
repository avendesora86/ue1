/**
 * Created by shari on 22.10.2017.
 */
public class Test {

    public static void main (String  [] args){
    test();
      //  testZwei();
    }

    public static void test (){
        int n = 0;

        for (int i = 0; i <50; i++) {
            if (n % 2 == 0) {
                System.out.println("gerade Zahl " + n);
            } else System.out.println("ungerade Zahl " + n);
            n++;
        }
    }

    public static void testZwei(){
        int x = 1;
        for (int i = 0; i <= 20; i++){
            x *= -1;
            System.out.println(x);
        }
    }
}
