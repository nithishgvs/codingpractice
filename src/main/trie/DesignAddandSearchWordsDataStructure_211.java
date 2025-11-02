package main.trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure_211 {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, TrieNode current) {

            if (index == word.length()) {
                return current.isEndOfWord;
            }

            char ch = word.charAt(index);
            if (ch == '.') {
                // Try all possible children
                for (TrieNode child : current.children.values()) {
                    if (dfs(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode next = current.children.get(ch);
                if (next == null) return false;
                return dfs(word, index + 1, next);
            }
        }

    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

