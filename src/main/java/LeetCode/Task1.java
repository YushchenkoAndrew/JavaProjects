package main.java.LeetCode;

import article.CorrectionPrint;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        int[] testData = new int[]{2, 7, 11, 15};
        CorrectionPrint.printArray(twoSumSolution3(testData, 9));
    }

    /**
     * This method is my first task in LeetCode, in which I'll get the Array and I need to find
     * the index of this array that get me exactly the same result like in target
     */

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if(nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                    break;
                }
        return result;
    }

    public static int[] twoSumSolution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int  i = 0; i < nums.length; i++) {
            int store = target - nums[i];
            if(map.containsKey(store) && map.get(store) != i)
                return new int[]{i, map.get(store)};
        }
        return null;
    }

    public static int[] twoSumSolution3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int store = target - nums[i];
            if (map.containsKey(store))
                return new int[]{i, map.get(store)};
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] isContains(int nums[], int value) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == value)
                return new int[]{1, i};

        return new int[]{0, 0};
    }

    public static int[] twoSumSolution4(int[] nums, int target) {

        for (int  i = 0; i < nums.length; i++) {
            int store[] = isContains(nums, target - nums[i]);
            if(store[0] == 1 && store[1] != i)
                return new int[]{i, store[1]};
        }
        return null;
    }
}
