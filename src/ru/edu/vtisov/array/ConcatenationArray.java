package ru.edu.vtisov.array;

public class ConcatenationArray {

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n * 2];
        System.arraycopy(nums, 0, answer, 0, n);
        System.arraycopy(nums, 0, answer, n, n);
        return answer;
    }
}