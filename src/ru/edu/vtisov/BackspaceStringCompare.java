package ru.edu.vtisov;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int posS = s.length() - 1;
        int posT = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (posS >= 0 || posT >= 0) {
            while(posS >= 0) {
                if (s.charAt(posS) == '#') {
                    skipS++;
                    posS--;
                } else if(skipS > 0) {
                    skipS--;
                    posS--;
                } else {
                    break;
                }
            }
            while(posT >= 0) {
                if (t.charAt(posT) == '#') {
                    skipT++;
                    posT--;
                } else if(skipT > 0) {
                    skipT--;
                    posT--;
                } else {
                    break;
                }
            }
            if (posS < 0 || posT < 0) break;
            if (s.charAt(posS) != t.charAt(posT)) {
                return false;
            }
            posS--;
            posT--;
        }
        return posS < 0 && posT < 0;
    }
}