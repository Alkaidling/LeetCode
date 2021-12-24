package leetcode.editor.cn;

import leetcode.editor.cn.acwing.c.Prim;
import leetcode.editor.cn.acwing.d.Prime;

import java.util.*;

//剑指 Offer II 031、最近最少使用缓存
class OrIXps {
    public static void main(String[] args) {
        LRUCache lRUCache = new OrIXps().new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class MyHashMap {
            private static final int PRIME = 10007;
            int cnt = 0;
            LinkedList[] data;

            public MyHashMap() {
                data = new LinkedList[PRIME];
                for (int i = 0; i < PRIME; i++) {
                    data[i] = new LinkedList<ListNode>();
                }
            }

            public void put(int key, ListNode value) {
                int hash = getHash(key);
                LinkedList<ListNode> list = data[hash];
                list.offerLast(value);
                cnt++;
            }

            public ListNode get(int key) {
                int hash = getHash(key);
                LinkedList<ListNode> list = data[hash];
                Iterator<ListNode> iterator = list.iterator();
                while (iterator.hasNext()) {
                    ListNode node = iterator.next();
                    if (node.key == key) {
                        return node;
                    }
                }
                return null;
            }

            public boolean containsKey(int key) {
                int hash = getHash(key);
                LinkedList<ListNode> list = data[hash];
                Iterator<ListNode> iterator = list.iterator();
                while (iterator.hasNext()) {
                    ListNode node = iterator.next();
                    if (node.key == key) {
                        return true;
                    }
                }
                return false;
            }

            public void remove(int key) {
                int hash = getHash(key);
                LinkedList<ListNode> list = data[hash];
                Iterator<ListNode> iterator = list.iterator();
                while (iterator.hasNext()) {
                    ListNode node = iterator.next();
                    if (node.key == key) {
                        list.remove(node);
                        cnt--;
                    }
                }
            }

            public int size(){
                return cnt;
            }

            private int getHash(int key) {
                return key % PRIME;
            }
        }

        class ListNode {
            public int key;
            public int value;
            public ListNode prev;
            public ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int capacity;
        //Map<Integer, ListNode> map;
        MyHashMap map;
        ListNode head;
        ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            //map = new HashMap<>();
            map = new MyHashMap();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                node.value = value;
                moveToTail(node);
            } else {
                if (map.size() == capacity) {
                    ListNode del = head.next;
                    deleteNode(del);
                    map.remove(del.key);
                }
                ListNode node = new ListNode(key, value);
                insertToTail(node);
                map.put(key, node);
            }
        }

        private void moveToTail(ListNode node) {
            deleteNode(node);
            insertToTail(node);
        }

        private void insertToTail(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }

        private void deleteNode(ListNode node) {
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