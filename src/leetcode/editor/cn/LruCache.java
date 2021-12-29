package leetcode.editor.cn;

import java.util.*;

//146、LRU 缓存
class LruCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LruCache().new LRUCache(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class ListNode{
            int key;
            int value;
            ListNode prev;
            ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer,ListNode> map;
        int capacity;
        ListNode head;
        ListNode tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            delete(node);
            insertToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            ListNode node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                delete(node);
            }else {
                if (map.size() == capacity) {
                    ListNode first = head.next;
                    delete(first);
                    map.remove(first.key);
                }
                node = new ListNode(key, value);
            }
            map.put(key,node);
            insertToTail(node);
        }

        private void insertToTail(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }

        private void delete(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}