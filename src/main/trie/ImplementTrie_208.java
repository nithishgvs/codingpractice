package main.trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208 {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = findNode(word);
            return node != null && node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }

        private TrieNode findNode(String str) {
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                current = current.children.get(ch);
                if (current == null) return null;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        ImplementTrie_208.Trie object = new ImplementTrie_208().new Trie();
        object.insert("abc");
        object.search("abcd");
        object.startsWith("ab");
        System.out.println();
    }
}
