package main.greedy;

import java.util.Arrays;

public class BoatstoSavePeople_881 {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int numBoats = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            numBoats++;
            right--;
        }

        return numBoats;
    }

    public static void main(String[] args) {
        BoatstoSavePeople_881 solution = new BoatstoSavePeople_881();
        int[] people = {5, 1, 4, 2};
        System.out.println(solution.numRescueBoats(people, 6));
    }
}
