/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigInteger;

/**
 *
 * @author trinh
 */
public class changeBase {

    //123 -> 3 * 16^0 + 2 * 16^1 + 1 *16^2
    public static String AllToDec(String value, String radix) {
        String Mydigits = "0123456789ABCDEF";
        String result;
        BigInteger resultInt = new BigInteger("0");
        BigInteger base = new BigInteger("1");
        BigInteger radix1 = new BigInteger(radix);
        value = value.toUpperCase();
        //run end index to index first
        for (int i = value.length() - 1; i >= 0; --i) {
            int factor = Mydigits.indexOf(value.charAt(i));
            BigInteger newFactor = new BigInteger(String.valueOf(factor));
            resultInt = resultInt.add(newFactor.multiply(base));
            base = base.multiply(radix1);
        }
        result = String.valueOf(resultInt);
        return result;
    }


    public static String DecToAll(String DecValue, String radix) {
        char[] Mydigits = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        BigInteger value = new BigInteger(DecValue);
        BigInteger base = new BigInteger(radix);
        String result = "";
        //The loop runs if the value is not 0
        while (value.intValue() != 0) {
            BigInteger surplus = value.mod(base);
            result = Mydigits[surplus.intValue()] + result;
            value = value.divide(base);
        }
        return result;
    }
}
//16 ABCDEF123456789
//DecToALl(700997, 16) = "AB245" 
//        700997 / 16 = 43812 du 5   -> 5 -> mydigits[5]  = '5'
//        43812  / 16 = 2738  du 4   -> 4 -> mydigits[4]  = '4'
//        2738   / 16 = 171   du 2   -> 2 -> mydigits[2]  = '2'
//        171    / 16 = 10    du 11  -> B -> mydigits[11] = 'B'
//        10     / 16 = 0     du 10  -> A -> mydigits[10] = 'A'

