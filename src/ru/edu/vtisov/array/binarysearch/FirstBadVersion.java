package ru.edu.vtisov.array.binarysearch;

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (isBadVersion(pivot)) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }

        }
        return left;
    }
}

class VersionControl {

    boolean isBadVersion(int n) {
        return true;
    }

}
