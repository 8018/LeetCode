package me.xfly.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_214 {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }

    /*public static String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        List<Character> result = new ArrayList<>();

        for (int i = 0;i<chars.length;i++){
            result.add(chars[i]);
        }

        if (length <= 1) {
            return s;
        }

        if (isValid(result)) {
            return s;
        }


        int n = chars.length;

        for (int i = 0; i < length - 1; i++) {

            for (int j = i;j >=0;j--){
                result.add(0,chars[chars.length-1-j]);
            }

            if (isValid(result)){
                return toString(result);
            }

            while (result.size() > chars.length){
                result.remove(0);
            }
        }

        return toString(result);

    }

    private static String toString(List<Character> chars){
        StringBuffer buffer = new StringBuffer();
        for (char c:chars){
            buffer.append(c);
        }
        return buffer.toString();
    }



    private static boolean isValid(List<Character> chars) {
        int middle = chars.size() / 2;

        for (int i = 0; i < middle; i++) {
            if (chars.get(i) != chars.get(chars.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }*/

    public static String shortestPalindrome(String s){
        String longestSub = getLongesstSubString(s);
        String result = longestSub;
        for (int i = longestSub.length(); i <s.length() ; i++) {
            result = s.substring(i,i+1)+result+s.substring(i,i+1);

        }
        return result;
    }

    public static String getLongesstSubString(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = 0;

        if (chars.length <=1){
            return s;
        }

        String valid = s.substring(0,1);

        for (int i = 1;i<=n;i++){
            String sub = s.substring(0,i);
            if (isValid(sub)){
                if (sub.length() > valid.length()){
                    valid = sub;
                }
            }
        }
        return valid;
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int middle = chars.length / 2;

        for (int i = 0; i < middle; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


}
