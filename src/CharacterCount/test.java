package CharacterCount;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws Exception {

        try {

            Scanner file = new Scanner(new File("alice.txt"));

            int[] intArray = new int[125];
            while (file.hasNext()) {
                String story = file.nextLine().toLowerCase();
                for (char ch : story.toCharArray()) {
                    intArray[(int) ch] = intArray[(int) ch] + 1;
                }
            }                                                   //from a to z
            int[] charsArray = Arrays.copyOfRange(intArray, 97, 123);
            int totalChar = 0;
            for (int chars : charsArray
                    ) {
                //counts how many characters of each type there is
                System.out.println(chars);
                totalChar = totalChar + chars;
                //counts total amount of chars
            }
            System.out.println(totalChar);
            double[] percentArray = new double[26];
            for (int i = 0; i < percentArray.length; i++) {
                percentArray[i] = (double) charsArray[i] / totalChar;
            }
            for (double d : percentArray
                    ) {
                System.out.println(d);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}