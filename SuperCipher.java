// CSCI 1913
//
// Author: Ethan Cook

public class SuperCipher extends BaseCipher{

    private BaseCipher[] ciphers;

    /**
     * (again used a funny string name because I had no reason to coordinate it with the others as is allowed)
     * Constructor for the class.
     * @param ciphers
     */
    public SuperCipher(BaseCipher[] ciphers) {
        super("hubblebub");
        this.ciphers = ciphers;

    }

    /**
     * Checks if each passed cipher in ciphers is valid.
     * @return
     */
    public boolean isValid() {
        for(int i = 0; i < ciphers.length; i++){
            if (ciphers[i].isValid()){

            }
            else{
                return false;
            }
        }

        return true;
    }

    /**
     * Encrypts the passed string (en) by each cipher within the cipher array (ciphers) in order.
     * @param en
     * @return
     */
    public String encrypt(String en){

        for(int i = 0; i < ciphers.length; i++) {
            en = ciphers[i].encrypt(en);

        }

        return en;
    }

    /**
     * Decrypts the passed string (en) by each cipher within the cipher array (ciphers) in BACKWARDS order.
     * @param de
     * @return
     */
    public String decrypt(String de){

        for(int i = (ciphers.length-1); i > -1 ; i--) {
            de = ciphers[i].decrypt(de);

        }

        return de;
    }

    /**
     * This toString of the class displays in the format of which cipher is being applied in order and separates each
     * cipher with a " | ".
     * @return
     */
    public String toString(){
        String superString = "SuperCipher(";
        for(int i = 0; i < ciphers.length; i++){
            if (i > 0){
                superString += " | ";
            }
            superString += ciphers[i].toString();
        }

        superString += ")";

        return superString;

    }

    /**
     * Checks of an object is equal to another of this class by first checking if the passed one is of the same class,
     * then checks if the number of ciphers contained are equal to each other,
     * then checks if their contained cipher at each index at (objectname).ciphers is equal to each other,
     * then returns true.
     *
     * otherwise to any of the previous returns false
     * @param o
     * @return
     */
    public boolean equals(Object o){

        if (o instanceof SuperCipher) {
            SuperCipher objectCipher = (SuperCipher) o;
            if (this.ciphers.length != objectCipher.ciphers.length){
                return false;

            }
            else{
                for (int i = 0; i < this.ciphers.length; i++){
                    if (! this.ciphers[i].equals(objectCipher.ciphers[i]) ){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
