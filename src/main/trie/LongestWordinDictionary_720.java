package main.trie;

import java.util.*;

public class LongestWordinDictionary_720 {

    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.isEndOfWord = false;
            this.children = new HashMap<>();
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode next = current.children.getOrDefault(ch, new TrieNode());
                current.children.put(ch, next);
                current = next;
            }

            current.isEndOfWord = true;
        }

        void dfs(TrieNode node, StringBuilder currentWord) {
            if (currentWord.length() > result.length() || (currentWord.length() == result.length() && result.compareTo(currentWord.toString()) > 0))
            {
                result = currentWord.toString();
            }

            List<Character> keys = new ArrayList<>(node.children.keySet());
            Collections.sort(keys);
            for (Character ch : keys) {
                TrieNode child = node.children.get(ch);
                if (!child.isEndOfWord)
                    continue;
                currentWord.append(ch);
                dfs(child, currentWord);
                currentWord.deleteCharAt(currentWord.length() - 1);
            }

        }
    }

    private final Trie trie = new Trie();
    private String result = "";

    public String longestWord(String[] words) {

        for (String word : words) {
            trie.insert(word);
        }

        trie.dfs(trie.root, new StringBuilder());
        return result;
    }

    public static void main(String[] args) {
        LongestWordinDictionary_720 obj = new LongestWordinDictionary_720();
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(obj.longestWord(words));
    }
}
