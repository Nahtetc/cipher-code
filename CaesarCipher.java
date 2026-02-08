// CSCI 1913
//
// Author: Ethan Cook


public class CaesarCipher extends BaseCipher{
    
    //Private vars
    private int key;

    /**
     * This is the constructor for the class that simply assigns the private variable key a value and allows basecipher
     * to be extended with the super(). (And yes, I know duckI isn't a formal string, but in slack it said that
     * it was fine to use any.
     * @param key
     */
    public CaesarCipher(int key) {
        super("duckI");
        this.key = key;
    }


    /**
     * Checks for if a valid key was passed to the class (1-25) because those are the only values that will actually
     * modify and edit text.
     * @return
     */
    public boolean isValid(){
        boolean valid = key >= 1 && key <= 25;

        return valid;
    }

    /**
     * Takes a string (en) and puts it into an array in order to change each letter individually using the letterChange
     * helper function then revert the character array back into a string and returns that variable.
     * @param en
     * @return
     */
    public String encrypt(String en){
        
        en = en.toLowerCase();
        int origLetter = 0;
        char[] charArr = en.toCharArray();
        for (int i = 0; i < charArr.length; i++){
            charArr[i] = letterChange(charArr[i], key);
        }
        en = String.valueOf(charArr);//revertToString(charArr);

        return en;
    }


    /**
     * Similar to the encrypt function takes a string parameter (de) then turns each letter of it into an index
     * of a character array to then pass those letters to a helper function that changes the letter if applicable and
     * then reverts the array to a string variable to be returned.
     * @param de
     * @return
     */
    public String decrypt(String de){
        int origLetter = 0;
        int newKey = 0 - key;
        char[] charArr = de.toCharArray();
        for (int i = 0; i < charArr.length; i++){
            charArr[i] = letterChange(charArr[i], newKey);
        }
        de = String.valueOf(charArr);//revertToString(charArr);

// NEGATIVE ONE
        return de;
    }

    /**
     * takes the letter that is desired to change and key value as a local variable to not mess with the private version
     * of it and therefore use the two parameters to first find the number of letter in the alphabet and use that with
     * the key value from -26 to 52 which is then computed with modulo 26 to find 1-26 which dictates which letter is
     * the new desirable one and then proceed to return it or if it isnt a letter then it will just return the same
     * letter as was passed.
     * @param letter
     * @param key
     * @return
     */
    private char letterChange(char letter, int key){
        int origLetter = letter - 'a';
        if ((key + origLetter) <= 0){
            origLetter += 26;
        }
        char newChar = 'a';
        if (letter >= 'a' && letter <= 'z') {
            newChar = (char) ('a' + ((key + origLetter) % 26));
        }
        else{
        return letter;

        }
        return newChar;
    }

    /**
     * A simple to string to say the key and what cipher is occurring.
     * @return
     */
    public String toString(){

        return "Caesar("+key+")";
    }


    public boolean equals(Object o) {
        boolean keyCheck = false;
        if (this == o){
            return true;
    }
        else if (o == null){
        return false;
    }
        else if (o instanceof CaesarCipher) {
            CaesarCipher test = (CaesarCipher) o;
            if (this.key == test.key){
                return true;
            }
        }

        return keyCheck;
    }


}