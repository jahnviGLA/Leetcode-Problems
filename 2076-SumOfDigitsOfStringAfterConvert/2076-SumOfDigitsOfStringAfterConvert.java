// Last updated: 1/19/2026, 1:14:58 PM
class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int position = s.charAt(i) - 'a' + 1;
            str += position;
        }
        int number = 0;
        for (char c : str.toCharArray()) {
            number += c - '0';
        }
        for (int i = 1; i < k; i++) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }

        return number;
    }
}
