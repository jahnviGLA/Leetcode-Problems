// Last updated: 5/29/2026, 12:39:11 AM
1class TrieNode {
2
3    TrieNode[] children = new TrieNode[26];
4    int minLen = Integer.MAX_VALUE;
5    int idx = Integer.MAX_VALUE;
6
7    TrieNode() {
8        for (int i = 0; i < 26; i++) {
9            children[i] = null;
10        }
11    }
12}
13
14class Trie {
15
16    TrieNode root = new TrieNode();
17
18    void insert(String s, int idx) {
19        int len = s.length();
20        TrieNode node = root;
21
22        if (len < node.minLen) {
23            node.minLen = len;
24            node.idx = idx;
25        }
26
27        for (char ch : s.toCharArray()) {
28            int c = ch - 'a';
29            if (node.children[c] == null) {
30                node.children[c] = new TrieNode();
31            }
32            node = node.children[c];
33
34            if (len < node.minLen) {
35                node.minLen = len;
36                node.idx = idx;
37            }
38        }
39    }
40
41    int query(String s) {
42        TrieNode node = root;
43
44        for (char ch : s.toCharArray()) {
45            int c = ch - 'a';
46            if (node.children[c] != null) {
47                node = node.children[c];
48            } else {
49                break;
50            }
51        }
52
53        return node.idx;
54    }
55}
56
57class Solution {
58
59    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
60        Trie trie = new Trie();
61
62        for (int i = 0; i < wordsContainer.length; i++) {
63            String reversed = new StringBuilder(wordsContainer[i])
64                .reverse()
65                .toString();
66            trie.insert(reversed, i);
67        }
68
69        int[] res = new int[wordsQuery.length];
70        for (int i = 0; i < wordsQuery.length; i++) {
71            String query = wordsQuery[i];
72            String reversed = new StringBuilder(query).reverse().toString();
73            res[i] = trie.query(reversed);
74        }
75
76        return res;
77    }
78}