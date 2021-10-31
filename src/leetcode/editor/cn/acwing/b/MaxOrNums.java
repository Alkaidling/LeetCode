package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-31 15:18
 * @ClassName MaxOrNums
 * @Description: 143. 最大异或对
 */

public class MaxOrNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int res = 0;
        for (int num : nums) {
            trie.insert(num);
            res = Math.max(res,trie.search(num));
        }
        System.out.println(res);
    }
    static class Trie {
        private int[][] son;
        private int head;
        public Trie() {
            son = new int[3000000][2];
        }

        public void insert(int x) {
            int p = 0;
            for (int i = 30; i >= 0; i--) {
                int u = (x >> i) & 1;
                if (son[p][u] == 0) {
                    son[p][u] = ++head;
                }
                p = son[p][u];
            }
        }

        public int search(int x) {
            int p = 0;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int u = (x >> i) & 1;
                if(son[p][1-u] != 0){
                    res = res * 2 + 1;
                    p = son[p][1-u];
                }else {
                    p = son[p][u];
                    res = res * 2;
                }
            }
            return res;
        }
    }
}
