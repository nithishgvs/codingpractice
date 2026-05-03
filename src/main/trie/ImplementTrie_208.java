package main.trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208 {


    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new HashMap<>();
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = current.children.getOrDefault(word.charAt(i), new TrieNode());
                current.children.put(word.charAt(i), newNode);
                current = newNode;
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {

            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = current.children.get(word.charAt(i));
                if (newNode == null)
                    return false;
                current = newNode;
            }

            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode newNode = current.children.get(prefix.charAt(i));
                if (newNode == null)
                    return false;
                current = newNode;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        ImplementTrie_208.Trie trie = new ImplementTrie_208().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }
}
