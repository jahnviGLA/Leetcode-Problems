// Last updated: 1/19/2026, 1:15:37 PM
import java.util.*;
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneSet = new HashSet<>(Arrays.asList(bank));
        if (!geneSet.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        char[] genes = {'A', 'C', 'G', 'T'};
        int mutations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return mutations;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = arr[j];
                    for (char g : genes) {
                        if (g == old) continue;
                        arr[j] = g;
                        String next = new String(arr);
                        if (geneSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            mutations++;
        }
        return -1;
    }
}
