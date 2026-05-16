package util;

public class ValidationUtil {
    public static boolean isBoardValid(
            int rows,
            int columns){

        return (rows*columns)%2==0;
    }
}
