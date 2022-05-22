package ru.edu.vtisov.array;

// https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // public int findDuplicate(int[] nums) {
    //     while(nums[0] != nums[nums[0]]) {
    //         int temp = nums[nums[0]];
    //         nums[nums[0]] = nums[0];
    //         nums[0] = temp;
    //     }
    //     return nums[0];
    // }

}
