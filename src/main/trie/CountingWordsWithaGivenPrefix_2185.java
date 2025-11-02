package main.trie;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountingWordsWithaGivenPrefix_2185 {

    //Best solution made it complicated using Trie
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.indexOf(pref) == 0) count++;
        }
        return count;

    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        int passCount;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.passCount = 0;
        }
    }

    TrieNode root;

    public int prefixCount1(String[] words, String pref) {
        root = new TrieNode();
        for (String word : words) {
            addWord(word);
        }
        return countWithPrefix(pref);
    }

    private int countWithPrefix(String pref) {
        TrieNode current = root;

        for (int i = 0; i < pref.length(); i++) {
            current = current.children.get(pref.charAt(i));
            if (current == null)
                return 0;
        }
        return current.passCount;
    }

    private void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.passCount++;
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.passCount++;
        current.isEndOfWord = true;
    }


    @Test
    public void test() {
        prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at");
    }
}
