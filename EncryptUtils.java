// CSCI 1913
//
// Author: Ethan Cook


public class EncryptUtils extends BaseCipher{

    /**
     * A constructor that simply allows the extension of BaseCipher.
     * 
     * note- I understand that it probably doesn't need cipherName to be inside the super, but it didn't affect the 
     * rest of the code, so I left it plain.
     * @param cipherName
     */
    public EncryptUtils(String cipherName) {
        super(cipherName);
    }

    /**
     * First will create a completely new copy of the String array in order to not mess with the original pointer
     * then using the copy will do the passed baseCipher encryption to each string given.
     * @param baseEnVariable
     * @param stringEnArray
     * @return
     */
    public static String[] encryptMany(BaseCipher baseEnVariable, String[] stringEnArray){
        String newStringEnArray[] = new String[stringEnArray.length];

        for (int i = 0; i < stringEnArray.length; i++) {
            newStringEnArray[i] = baseEnVariable.encrypt(stringEnArray[i]);
        }


        return newStringEnArray;
    }

    /**
     * First will create a completely new copy of the String array in order to not mess with the original pointer
     * then using the copy will do the passed baseCipher decryption to each string given.
     * @param baseDeVariable
     * @param stringDeArray
     * @return
     */
    public static String[] decryptMany(BaseCipher baseDeVariable, String[] stringDeArray){
        String newStringDeArray[] = new String[stringDeArray.length];

        for (int i = 0; i < stringDeArray.length; i++) {
            newStringDeArray[i] = baseDeVariable.decrypt(stringDeArray[i]);
        }


        return newStringDeArray;
    }



}