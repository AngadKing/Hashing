import java.lang.*;

public class Hashing {
     public static int hashing(String input ){
        int sum = 0;
        for(int i = 0 ;  i < input.length() ; i++){
            sum = sum + (int) input.charAt(i);
        }
        return sum;
    }
}