package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

//705、设计哈希集合
class DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new DesignHashset().new MyHashSet();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1);
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        public static final int MOD = 857;
        private LinkedList[] data;

        public MyHashSet() {
            data = new LinkedList[MOD];
            for (int i = 0; i < MOD; i++) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int h = calculateHash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()){
                int num = iterator.next();
                if (num == key) {
                    return;
                }
            }
            data[h].offerLast(key);
        }

        public void remove(int key) {
            int h = calculateHash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer num = iterator.next();
                if (num == key) {
                    data[h].remove(num);
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int h = calculateHash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer num = iterator.next();
                if (num == key) {
                    return true;
                }
            }
            return false;
        }

        private int calculateHash(int key) {
            return key % MOD;
        }
    }
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
//class MyHashSet {
    //    private static final int MOD = 857;
    //    private int[] hash;
    //    private int[][] lists;
    //
    //    public MyHashSet() {
    //        hash = new int[MOD];
    //        Arrays.fill(hash,-1);
    //        lists = new int[MOD][];
    //    }
    //
    //    public void add(int key) {
    //        int hashKey = calculateHash(key);
    //        if (hash[hashKey] == -1) {
    //            hash[hashKey] = key;
    //            int[] list = new int[10007];
    //            Arrays.fill(list,-1);
    //            lists[hashKey] = list;
    //        }else if(hash[hashKey] != hashKey){
    //            int[] list = lists[hashKey];
    //            for (int i = 0; i < list.length; i++) {
    //                if (list[i] == hashKey) {
    //                    break;
    //                }
    //                if(list[i] == -1){
    //                    list[i] = key;
    //                    break;
    //                }
    //            }
    //        }
    //    }
    //
    //    public void remove(int key) {
    //        int hashKey = calculateHash(key);
    //        if(hash[hashKey] != -1){
    //            if (hash[hashKey] == key) {
    //                int[] list = lists[hashKey];
    //                hash[hashKey] = list[0];
    //                for (int i = 1; i < list.length; i++) {
    //                    if (list[i] == -1) {
    //                        break;
    //                    }
    //                    list[i-1] = list[i];
    //                }
    //            }else {
    //                int[] list = lists[hashKey];
    //                if(list[0] == -1){
    //                    hash[hashKey] = -1;
    //                }else {
    //                    for (int i = 0; i < list.length; i++) {
    //                        if (list[i] == key) {
    //                            list[i] = list[i+1];
    //                        }
    //                        if (list[i] == -1 && i > 0) {
    //                            list[i-1] = -1;
    //                            break;
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //    }
    //
    //    public boolean contains(int key) {
    //        int hashKey = calculateHash(key);
    //        if(hash[hashKey] != -1){
    //            if (hash[hashKey] == key) {
    //                return true;
    //            }else {
    //                int[] list = lists[hashKey];
    //                for (int i : list) {
    //                    if (i == key) {
    //                        return true;
    //                    }
    //                    if (i == -1) {
    //                        break;
    //                    }
    //                }
    //                return false;
    //            }
    //        }else {
    //            return false;
    //        }
    //    }
    //
    //    private int calculateHash(int key) {
    //        return key % MOD;
    //    }
    //}

}