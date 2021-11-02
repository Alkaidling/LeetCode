package leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;

//706、设计哈希映射
class DesignHashmap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new DesignHashmap().new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        public static final int MOD = 857;
        private LinkedList[] data;

        public MyHashMap() {
            data = new LinkedList[MOD];
            for (int i = 0; i < MOD; i++) {
                data[i] = new LinkedList<Node>();
            }
        }

        public void put(int key, int value) {
            int h = calculateHash(key);
            Node node = new Node(key,value);
            Iterator iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Node next = (Node) iterator.next();
                if(next.key == key){
                    next.value = value;
                    return;
                }
            }
            data[h].offerLast(node);
        }

        public int get(int key) {
            int h = calculateHash(key);
            Iterator iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Node next = (Node) iterator.next();
                if(next.key == key){
                    return next.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h = calculateHash(key);
            Iterator iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Node next = (Node) iterator.next();
                if(next.key == key){
                    data[h].remove(next);
                    return;
                }
            }
        }

        private int calculateHash(int key) {
            return key % MOD;
        }
    }
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}