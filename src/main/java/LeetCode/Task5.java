package main.java.LeetCode;

import javax.swing.plaf.metal.MetalSliderUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bababd"));

    }

    public static String longestPalindrome(String s) {
        StringBuilder result = new StringBuilder(new String(""));
        StringBuilder store = new StringBuilder(new String(""));
        StringBuilder correction = new StringBuilder("");
        Map<Character, Integer> map = new HashMap<>();
        int  i = 0;
        int j = 0;
        int k = 0;
        while (i < s.length() && j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                if (k != 0) {
                    k = 0;
                    result = result.length() > store.length() ? result : store;
                    store = new StringBuilder("");
                }
                map.put(s.charAt(j), ++j);
                System.out.println(map);
            } else {
                System.out.println(map);
                if (j - map.get(s.charAt(j)) <= 2 * k + (j - map.get(s.charAt(j))) % 2) {
                    if (k == 0 && (j - map.get(s.charAt(j))) % 2 == 1)
                        correction.append(s.charAt(j - 1));
                    store.append(s.charAt(j));
                    k++;
                }
                map.remove(s.charAt(j++));
            }
        }
        System.out.println(correction);
        System.out.println(result);
        return result.reverse().toString() + correction.toString() + result.reverse().toString();
    }
}
