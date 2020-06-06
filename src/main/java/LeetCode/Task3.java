package main.java.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        String test = new String("abba");
        System.out.println(lengthOfLongestSubstringSolution2(test));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
            else
                set.remove(s.charAt(i++));
        }
        return result;
    }

    public static int lengthOfLongestSubstringSolution2(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);

            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
