
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class DecimalNumberTools {

    public static boolean isInteger(float n){
        int i=(int)n;
        return n-i==0;
    }

    public static String formatFloat(float n,int digitsAfterPoint){
        String floatingString="%".concat(String.format(Locale.getDefault(),".%df",digitsAfterPoint));
        return String.format(floatingString,n);
    }

    public static String formatFloat(float n){return formatFloat(n,getDigitsAfterPoint(n));}

    public static int getDigitsAfterPoint(float n){
        BigDecimal bigDecimal=new BigDecimal(Float.toString(n));
        int i=0;
        while (!isInteger(bigDecimal.floatValue())){
            i++;
            bigDecimal=bigDecimal.multiply(new BigDecimal(10));
        }
        return i;
    }

    public static float add(float a,float b){
        BigDecimal bA=new BigDecimal(Float.toString(a));
        BigDecimal bB=new BigDecimal(Float.toString(b));
        return bA.add(bB).floatValue();
    }

    public static float multiply(float a,float b){
        BigDecimal bA=new BigDecimal(Float.toString(a));
        BigDecimal bB=new BigDecimal(Float.toString(b));
        return bA.multiply(bB).floatValue();
    }

    public static float subtract(float a,float b){
        BigDecimal bA=new BigDecimal(Float.toString(a));
        BigDecimal bB=new BigDecimal(Float.toString(b));
        return bA.subtract(bB).floatValue();
    }

      public static float divide(float a,float b,int scale){
        BigDecimal bA=new BigDecimal(Float.toString(a));
        BigDecimal bB=new BigDecimal(Float.toString(b));
        return bA.divide(bB,scale, RoundingMode.CEILING).floatValue();
    }

    public static float divide(float a,float b){
        BigDecimal bA=new BigDecimal(Float.toString(a));
        BigDecimal bB=new BigDecimal(Float.toString(b));
        return bA.divide(bB,RoundingMode.CEILING).floatValue();
    }

    public static float roundTo(float a,int n){
        int tenPower=(int) Math.pow(10,n);
        int i=new BigDecimal(Float.toString(a)).multiply(BigDecimal.valueOf(tenPower)).intValue();
        return BigDecimal.valueOf(i).divide(BigDecimal.valueOf(tenPower),n,RoundingMode.CEILING).floatValue();
    }
}
