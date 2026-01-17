package main.bdfs;

import org.junit.Test;

import java.util.*;

public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int totalSteps = 1;
        Set<String> visitedWords = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visitedWords.remove(beginWord);


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (endWord.equals(currentWord))
                    return totalSteps;
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] charArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String newWord = String.valueOf(charArray);
                        if (!visitedWords.contains(newWord))
                            continue;
                        queue.add(newWord);
                        visitedWords.remove(newWord);
                    }
                }
            }
            totalSteps++;
        }

        return 0;

    }

    @Test
    public void test() {
        String beginWord = "hit", endWord = "hit";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
