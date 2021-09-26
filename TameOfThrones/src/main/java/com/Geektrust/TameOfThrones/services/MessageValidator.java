package com.Geektrust.TameOfThrones.services;

import java.util.HashMap;
import java.util.Map;

public class MessageValidator {
    public static boolean isAllyOrNot(String decodedMessage,String emblemValue) {
        HashMap<Character,Integer> messageCharCount=new HashMap<Character,Integer>();
        HashMap<Character,Integer> emblemCharCount=new HashMap<Character,Integer>();
        messageCharCount= charCount(decodedMessage);
        emblemCharCount= charCount(emblemValue);
        int c=0;
        for (Map.Entry<Character, Integer> set : messageCharCount.entrySet()) {
            for (Map.Entry<Character, Integer> set1 : emblemCharCount.entrySet()) {
                if(set.getKey()==set1.getKey() && set.getValue()>=set1.getValue()) {
                    c+=set1.getValue();
                }
            }
        }
        if(c==emblemValue.length())
            return true;
        return false;
    }
    public static HashMap<Character, Integer> charCount(String str) {
        HashMap<Character,Integer> ch=new HashMap<>();
        for(int i=0;i<str.length();i++) {
            char x=str.charAt(i);
            ch.putIfAbsent(x, 0);
            Integer incrementedCount = ch.get(x) + 1;
            ch.put(x, incrementedCount);

        }
        return ch;
    }
}
