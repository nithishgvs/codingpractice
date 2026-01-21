package main.greedy;

import org.junit.Test;

import java.util.*;

public class HandofStraights_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> cards = new TreeMap<>();

        for (int h : hand) {
            cards.put(h, cards.getOrDefault(h, 0) + 1);
        }

        while (!cards.isEmpty()) {

            int first = cards.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int card = first + i;

                if (!cards.containsKey(card))
                    return false;

                int freq = cards.get(card);

                if (freq == 1)
                    cards.remove(card);
                else
                    cards.put(card, freq - 1);
            }
        }
        return true;
    }

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(nums, 3));
    }

    @Test
    public void test1() {

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(isNStraightHand(nums, 4));
    }
}
