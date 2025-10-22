package main.graphs;

import org.junit.Test;

import java.util.*;

public class KeysandRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(rooms.get(0));
        visited.add(0);

        while (!queue.isEmpty()) {
            int newRoom = queue.poll();
            if (visited.contains(newRoom)) {
                continue;
            }
            visited.add(newRoom);
            queue.addAll(rooms.get(newRoom));
        }

        return visited.size() == rooms.size();
    }

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(3, 0, 1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(0));
        canVisitAllRooms(list);
    }

    @Test
    public void test2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(Collections.emptyList());
        canVisitAllRooms(list);
    }
}
