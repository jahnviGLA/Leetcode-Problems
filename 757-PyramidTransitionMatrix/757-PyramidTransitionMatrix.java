// Last updated: 1/19/2026, 1:15:24 PM
import java.util.*;
class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return dfs(bottom);
    }
    private boolean dfs(String curr) {
        if (curr.length() == 1) return true;
        List<String> nextRows = new ArrayList<>();
        buildNextRows(curr, 0, new StringBuilder(), nextRows);
        for (String next : nextRows) {
            if (dfs(next)) return true;
        }
        return false;
    }
    private void buildNextRows(String curr, int idx, StringBuilder sb, List<String> res) {
        if (idx == curr.length() - 1) {
            res.add(sb.toString());
            return;
        }
        String key = curr.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;
        for (char c : map.get(key)) {
            sb.append(c);
            buildNextRows(curr, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
