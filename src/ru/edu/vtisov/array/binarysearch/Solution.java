package ru.edu.vtisov.array.binarysearch;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int x = 0, y = 0, z = 0, len1 = nums1.length, len2 = nums2.length, totalLen = len1 + len2, medianIdx = totalLen / 2, temp = 0;
        int valOne = 0, valTwo = 0;
        while (z <= medianIdx) {
            if (x < len1 && (y >= len2 || nums1[x] <= nums2[y])) {
                temp = nums1[x];
                x++;
            } else if (y < len2 && (x >= len1 || nums2[y] <= nums1[x])) {
                temp = nums2[y];
                y++;
            }
            valTwo = valOne;
            valOne = temp;
            z++;
        }
        result += valOne;
        if (totalLen % 2 == 0) {
            result += valTwo;
            result = result / 2;
        }

        return result;
    }
}
