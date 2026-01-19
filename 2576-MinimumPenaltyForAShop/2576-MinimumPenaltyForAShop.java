// Last updated: 1/19/2026, 1:14:52 PM
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int remainingY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') remainingY++;
        }
        int penalty = remainingY; 
        int minPenalty = penalty;
        int bestHour = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;  
            } else {
                penalty++;  
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
}
