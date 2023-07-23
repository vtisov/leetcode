package ru.edu.vtisov.array.binarysearch;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] array1, int[] array2) {
        int[] nums1 = array1.length > array2.length ? array2 : array1;
        int[] nums2 = array1.length > array2.length ? array1 : array2;

        int n = nums1.length;
        int m = nums2.length;

        int start = 0;
        int end = n;
        int mergedMid = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = mergedMid - mid;
            // checking overflow of indices
            int leftA = (leftAsize > 0) ? nums1[leftAsize - 1] : Integer.MIN_VALUE;
            int rightA = (leftAsize < n) ? nums1[leftAsize] : Integer.MAX_VALUE;
            int leftB = (leftBsize > 0) ? nums2[leftBsize - 1] : Integer.MIN_VALUE;
            int rightB = (leftBsize < m) ? nums2[leftBsize] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return 0.0;
    }
}
