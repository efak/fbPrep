import java.util.HashMap;
/**
 * One simple way to encrypt a string is to "rotate" every alphanumeric character 
 * by a certain amount. Rotating a character means replacing it with another 
 * character that is a certain number of steps away in normal alphabetic or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string 
 * is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters 
 * higher (wrapping around from Z to A), and every numeric character replaced with the 
 * character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric 
 * characters remain unchanged. Given a string and a rotation factor, return an encrypted string.
 */

public class RotateCipher {

        /*
     * 
     * Map each character to a number. a->0 b->1 c->2 etc.* Non-letter characters map to -1.
     */

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }

        if (A <= val && val <= Z) {
            return val - a;
        }

        return -1;
    }

    //create  a map for lowercase and uppercase
    HashMap<Integer, Character> buildCaseMap(char start, char end) {
        HashMap<Integer, Character> map = new HashMap<>();
        int i = 0;

        for (char c = start; c <= end; c++) {
            map.put(i, c);
            i++;
        }

        return map;
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder result = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        
        HashMap<Integer, Character> lowHashMap = buildCaseMap('a', 'z');
        HashMap<Integer, Character> upperHashMap = buildCaseMap('A', 'Z');

        for (char ch : inputCharArr) {
            if (Character.isAlphabetic(ch)) {
                int val = getCharNumber(ch);
                val = (val + rotationFactor) % 26;

                if (Character.isLowerCase(ch)) {

                    result.append(lowHashMap.get(val));
                } else {
                    result.append(upperHashMap.get(val));
                }
            }
            else if ( Character.isDigit(ch)){
                int val = Integer.parseInt(ch+"");
                val = (val + rotationFactor) % 10;
                result.append(val);
            }
            else{
                result.append(ch);                
            }
        }
        return result.toString();
    }
    
}
