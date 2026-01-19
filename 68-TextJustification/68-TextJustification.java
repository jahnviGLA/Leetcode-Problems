// Last updated: 1/19/2026, 1:16:50 PM
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int wordsCount = j - i;
            StringBuilder line = new StringBuilder();
            if (j == words.length || wordsCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            else {
                int totalChars = 0;
                for (int k = i; k < j; k++) {
                    totalChars += words[k].length();
                }
                int totalSpaces = maxWidth - totalChars;
                int gaps = wordsCount - 1;
                int spaceEach = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaceEach; s++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }
}
