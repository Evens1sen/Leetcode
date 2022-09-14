package array;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        lruCache.get(1);
//        lruCache.put(3, 3);
    }

    static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int size;
    Map<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }

        node = new ListNode(key, value);
        cache.put(key, node);
        moveToHead(node);
        size++;
        if (size > capacity) {
            ListNode evict = tail.prev;
            deleteNode(evict);
            cache.remove(evict.key);
            size--;
        }
    }

    private void moveToHead(ListNode node) {
        if (node.next != null && node.prev != null){
            deleteNode(node);
        }
        insertToHead(node);
    }

    private void deleteNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

}
