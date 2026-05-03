package main.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords_648 {

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
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode newNode = current.children.getOrDefault(ch, new TrieNode());
                current.children.put(ch, newNode);
                current = newNode;
            }
            current.isEndOfWord = true;
        }

        public String search(String word) {
            TrieNode current = root;

            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode next = current.children.get(ch);

                if (next == null) {
                    return null;
                }

                prefix.append(ch);
                current = next;

                if (current.isEndOfWord) {
                    return prefix.toString();
                }
            }

            return null;
        }

    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        dictionary.forEach(dict -> trie.insert(dict));
        String[] words = sentence.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            String search = trie.search(w);
            sb.append(search == null ? w : search).append(" ");
        }


        return sb.toString().trim();
    }


    public static void main(String[] args) {
        ReplaceWords_648 obj = new ReplaceWords_648();
        //System.out.println(obj.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(obj.replaceWords(Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }
}
