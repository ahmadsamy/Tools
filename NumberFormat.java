import java.util.Locale;

public class NumberFormat {

    public static boolean isInteger(float n){
        int i=(int)n;
        return n-i==0;
    }

    public static String formatFloat(float n,int digitsAfterPoint){
        String floatingString="%".concat(String.format(Locale.getDefault(),".%df",digitsAfterPoint));
        return String.format(floatingString,n);
    }

    public static String formatFloat(float n){return formatFloat(n,getDigitsAfterPoint(n));}

    private static int getDigitsAfterPoint(float n){
        float x=n;
        int i=0;
        while (!isInteger(x)){
            i++;
            x*=10;
        }
        return i;
    }


}
