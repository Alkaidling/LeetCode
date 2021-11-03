package leetcode.editor.cn.acwing.c;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 13:46
 * @ClassName Dfs
 * @Description:
 */
public class Dfs {
    public static int n;
    public static int[] path;
    public static boolean[] visit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visit = new boolean[n+1];
        path = new int[n+1];
        dfs(0);
    }

    public static void dfs (int u){
        if(u == n){
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                path[u] = i;
                visit[i] = true;
                dfs(u + 1);
                visit[i] = false;
            }
        }
    }
}
