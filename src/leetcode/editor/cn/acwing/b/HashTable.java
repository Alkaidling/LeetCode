package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/02 14:23
 * @ClassName HashTable
 * @Description: AcWing 840. 模拟散列表
 */
public class HashTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        MyHashSet myHashSet = new MyHashSet();
        while (n-- > 0) {
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("I")){
                myHashSet.add(Integer.parseInt(str[1]));
            }else {
                boolean b = myHashSet.contains(Integer.parseInt(str[1]));
                if (b) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
        reader.close();
    }

    static class MyHashSet {
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
            return (key % MOD + MOD) % MOD;
        }
    }
    class MyHashMap {
        public static final int MOD = 857;
        private LinkedList[] data;

        class Node {
            private int key;
            private int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

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
            return (key % MOD + MOD) % MOD;
        }
    }

}
