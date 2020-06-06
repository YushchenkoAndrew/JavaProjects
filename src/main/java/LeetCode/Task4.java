package main.java.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        int[] test1 = new int[]{};
        int[] test2 = new int[]{2, 3};
//        System.out.println(isContains(0, test1));

        System.out.println(findMedianSortedArrays2(test1, test2));
    }

    public static boolean isContains(int value, int[] array) {
        int min = 0;
        int max = array.length - 1;
        while (array[(min + max)  / 2] != value) {
            if ((min + max)  / 2 == 0)
                return false;
            if (array[(min + max)  / 2] > value)
                max = (min + max)  / 2;
            else
                min = (min + max)  / 2;
        }
        return true;
    }

    public static double function(int min, int max,int[] nums1, int[] nums2) {
        double store = (double) (min + max) / 2;
        while (!isContains((int)store, nums1) && !isContains((int)store, nums2)) {
//            store
        }
        return 0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int min1 = nums1.length != 0 ? nums1[0] : Integer.MAX_VALUE;
        int min2 = nums2.length != 0 ? nums2[0] : Integer.MAX_VALUE;
        int max1 = nums1.length != 0 ? nums1[nums1.length - 1] : Integer.MIN_VALUE;
        int max2 = nums2.length != 0 ? nums2[nums2.length - 1] : Integer.MIN_VALUE;
        return (double)(Math.min(min1, min2) + Math.max(max1, max2)) / 2;
    }

    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] store = A;
            A = B;
            B = store;
            m = A.length;
            n = B.length;
        }
        int iMin = 0, iMax = m, mid = (n + m + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int j = mid - i;
            if (i < iMax && B[j - 1] > A[i])
                iMin = i + 1;
            else if (i > iMin && A[i - 1] > B[j])
                iMax = i - 1;
            else {
                int leftMax = 0;
                if (i == 0)
                    leftMax = B[j - 1];
                else if (j == 0)
                    leftMax = A[i - 1];
                else leftMax = Math.max(A[i - 1], B[j - 1]);
                if ((n + m) % 2 == 1)
                    return leftMax;
                int rightMin = 0;
                if (i == m)
                    rightMin = B[j];
                else if (j == n)
                    rightMin = A[i];
                else rightMin = Math.min(A[i], B[j]);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0;
    }

}
