/**
 * Created by shari on 19.10.2017.
 */
public class Rekursion {

 public static void main(String [] args){

  System.out.println(rekursiv(4));
 }

 public static int rekursiv(int n){

  if (n == 1)
   return 1;
  else
   return rekursiv(n - 1) * n;

 }
}
