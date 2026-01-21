package main.designpatterns;

import java.util.HashMap;
import java.util.Map;

class LRUCache {


    private static class Node {
        private Integer key;
        private Integer value;
        Node previous;
        Node next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleLinkedList {
        private Node head;
        private Node tail;

        private DoubleLinkedList() {
            this.head = new Node(null, null);
            this.tail = new Node(null, null);
            this.head.next = this.tail;
            this.tail.previous = this.head;
        }

        private void addToHead(Node newNode) {
            Node firstNode = this.head.next;
            this.head.next = newNode;
            newNode.previous = this.head;
            newNode.next = firstNode;
            firstNode.previous = newNode;
        }

        private void removeNode(Node currentNode) {
            Node previous = currentNode.previous;
            Node next = currentNode.next;
            previous.next = next;
            next.previous = previous;
        }

        private void removeFromTail() {
            Node lastNode = this.tail.previous;
            Node lastButOneNode = lastNode.previous;
            lastButOneNode.next = this.tail;
            this.tail.previous = lastButOneNode;
        }
    }

    private Map<Integer, Node> lru;
    private DoubleLinkedList doubleLinkedList;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.lru = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.doubleLinkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!this.lru.containsKey(key))
            return -1;
        Node currentNode = lru.get(key);
        this.doubleLinkedList.removeNode(currentNode);
        this.doubleLinkedList.addToHead(currentNode);
        return currentNode.value;
    }

    public void put(int key, int value) {
        if (this.lru.containsKey(key)) {
            Node existingNode = this.lru.get(key);
            this.doubleLinkedList.removeNode(existingNode);
            existingNode.value = value;
            this.doubleLinkedList.addToHead(existingNode);
        } else {
            Node newNode = new Node(key, value);
            this.doubleLinkedList.addToHead(newNode);
            this.lru.put(key, newNode);
            size++;
        }

        if (size > capacity) {
            Node removed = this.doubleLinkedList.tail.previous;
            this.doubleLinkedList.removeFromTail();
            lru.remove(removed.key);
            size--;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

