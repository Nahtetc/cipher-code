// CSCI 1913
//
// Author: Ethan Cook

public class EvenOddCipher extends BaseCipher{

    /**
     * Constructor that allows EvenOddCipher to extend BaseCipher with the super (again same deal with the string value
     * as stated previously)
     */
    public EvenOddCipher() {
        super("duckTree");
    }

    /**
     * First--  turns string en to two character arrays    / initializes count
     * second-- then using the first loop sets all the even indexed letters of charTemp into the main character array
     * third--  Using the second loop the odd indexed letters are filled into the remaining spots of charArr
     * finally--       returns charArr back to a string to return
     *
     * note-- count is used to keep track of where to place the letters into charArr.
     * @param en
     * @return
     */
    public String encrypt(String en) {
        char[] charArr = en.toCharArray();
        char[] charTemp = en.toCharArray();
        int count = 0;


        for (int i = 0; i < charArr.length; i += 2){
            charArr[count] = charTemp[i];
            count++;
        }
        for (int i = 1; i < charArr.length; i += 2){
            charArr[count] = charTemp[i];
            count++;
        }


        en = String.valueOf(charArr);
        return en;
    }

/**
 * First--  turns string de to two character arrays    / initializes count
 * second-- then using the first loop all the first half of letters of charTemp are placed
 *          into the main character array in the even index positions.
 * third--  resets count to track odd indexes
 * forth--  The second loop starts at halfway through charTemp and places the remaining letters into charArr odd index
 *          positions.
 *
 * --- NOTE ---
 * I realize after revisiting this method that I could've sped it up and cleaned up the code into a single loop by
 * resetting the count variable better, but this works just as quick for runtime and allowed for more slight changes.
 *
 * note-- count is used to keep track of where to place the letters into charArr.
 * @param de
 * @return
 */
    public String decrypt(String de) {
        char[] charArr = de.toCharArray();
        char[] charTemp = de.toCharArray();
        int count = 0;


        for (int i = 0; i < charArr.length; i++) {
            charArr[count] = charTemp[i];
            count += 2;
            if (count >= charArr.length) {
                break;
            }
        }
        count = 1;
        for (int i = ((charArr.length + 1) / 2); i < charArr.length; i ++){
            charArr[count] = charTemp[i];
            count+= 2;
            if (count >= charArr.length) {
                break;
            }
        }


        de = String.valueOf(charArr);
        return de;
    }

    /**
     * the toString of the class that simply states it is a plain EvenOddCipher.
     * @return
     */
    public String toString() {

        return "EvenOddCipher";
    }

    /**
     * Checks if an object is an instance of this class.
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        return o instanceof EvenOddCipher;
    }
}