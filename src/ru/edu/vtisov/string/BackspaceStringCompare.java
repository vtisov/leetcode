package ru.edu.vtisov.string;

public class BackspaceStringCompare {
    private int getCurrentIndex(String s, int current) {
        int i = current;
        int toSkip = 0;
        while(i >= 0) {
            if (s.charAt(i) == '#')
                toSkip++;
            else if(toSkip > 0)
                toSkip--;
            else
                break;
            i--;
        }
        return i;
    }

    public boolean backspaceCompare(String s, String t) {
        int posS = s.length() - 1;
        int posT = t.length() - 1;
        while (posS >= 0 || posT >= 0) {
            posS = getCurrentIndex(s, posS);
            posT = getCurrentIndex(t, posT);
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