// Last updated: 3/17/2026, 11:41:04 PM
1class WordDictionary {
2    class TrieNode {
3        TrieNode[] children = new TrieNode[26];
4        boolean isEnd = false;
5    }
6    private TrieNode root;
7    public WordDictionary() {
8        root = new TrieNode();
9    }
10    public void addWord(String word) {
11        TrieNode node = root;
12        for (char c : word.toCharArray()) {
13            int idx = c - 'a';
14            if (node.children[idx] == null) {
15                node.children[idx] = new TrieNode();
16            }
17            node = node.children[idx];
18        }
19        node.isEnd = true;
20    }
21    public boolean search(String word) {
22        return dfs(word, 0, root);
23    }
24    private boolean dfs(String word, int index, TrieNode node) {
25        if (node == null) return false;
26        if (index == word.length()) {
27            return node.isEnd;
28        }
29        char c = word.charAt(index);
30        if (c != '.') {
31            return dfs(word, index + 1, node.children[c - 'a']);
32        }
33        for (TrieNode child : node.children) {
34            if (child != null && dfs(word, index + 1, child)) {
35                return true;
36            }
37        }
38        return false;
39    }
40}