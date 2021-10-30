package leetcode.editor.cn.acwing.b;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-30 15:04
 * @ClassName Trie
 * @Description: 字典树
 */

public class Trie {
    private static int[][] son = new int[100010][26];
    private static int[] cnt = new int[100010];
    private static int idx; //下标是0的点，既是根节点又是空节点

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String op = scanner.next();
            String str = scanner.next();
            if ("I".equals(op)) {
                insert(str.toCharArray());
            } else if ("Q".equals(op)) {
                System.out.println(query(str.toCharArray()));
            }
        }
    }

    private static void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    private static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }
}
