// CSCI 1913
//
// Author: Ethan Cook

public class WordReplacementCipher extends BaseCipher{
    //private vars
    private String wordInput;
    private String wordReplace;

    /**
     * Constructor for this class.
     * (again used a weird string for the super(string value) but in slack Dr. Kluver mentioned it being allowed.
     * Other than that simply assigns values to the private variables.
     * @param wordInput
     * @param wordReplace
     */
    public WordReplacementCipher(String wordInput, String wordReplace){
        super("duck2");
        this.wordInput = wordInput;
        this.wordReplace = wordReplace;

    }

    /**
     * Using a string passed to encrypt it will search for strings equal to wordInput and replace it with wordReplace.
     * @param en
     * @return
     */
    public String encrypt(String en){
        en = en.replace(wordInput, wordReplace);
        return en;
    }

    /**
     * Opposite of encrypt-- searches for wordReplace and replaces it with wordInput.
     * @param de
     * @return
     */
    public String decrypt(String de){
        de = de.replace(wordReplace, wordInput);
        return de;
    }

    /**
     * toString of class to display the class name and words being input and output into the strings.
     * @return
     */
    public String toString(){

        return "WordReplacementCipher("+wordInput + ", "+wordReplace+")";
    }

    /**
     * Checks for equality between an object and whether it matches the classes main word replaces and inputs
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        boolean keyCheck = false;
        if (this == o){
            return true;
        }
        else if (o == null){
            return false;
        }
        else if (o instanceof WordReplacementCipher) {
            WordReplacementCipher test = (WordReplacementCipher) o;
            if (this.wordInput == test.wordInput && this.wordReplace == test.wordReplace){
                return true;
            }
        }

        return keyCheck;
    }



}