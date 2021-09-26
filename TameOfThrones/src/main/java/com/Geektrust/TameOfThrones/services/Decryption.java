package com.Geektrust.TameOfThrones.services;

public class Decryption {
    public static String decipher(String message, int n) {
        StringBuilder result=new StringBuilder();
        for(int i = 0; i < message.length(); ++i){
            char ch = message.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch - n);

                if(ch < 'A'){
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }

                result.append(ch);
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }

}
