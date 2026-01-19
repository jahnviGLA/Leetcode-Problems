// Last updated: 1/19/2026, 1:17:02 PM
class Solution {
    public int lengthOfLastWord(String s) {
        int index = -1;

        // Remove all trailing spaces
        while (s.length() > 0 && s.charAt(s.length() - 1) == ' ') {
            s = s.substring(0, s.length() - 1);
        }

        // Find last space
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                index = i;
                break;
            }
        }

        return s.length() - index - 1;
    }
}
