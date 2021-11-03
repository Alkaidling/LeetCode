package leetcode.editor.cn.acwing.c;

import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 16:43
 * @ClassName TreeDfs
 * @Description: 846. 树的重心
 */
public class TreeDfs {
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ans = n + 1;
        Map<Integer,List<Integer>> tree = new HashMap<>();  //用于存树的邻接表，我用的数组，也可以用Map<Integer,List<Integer>>
        boolean[] state = new boolean[n + 1];  //用于判断结点i是否被访问过，下标从1开始
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            if (!tree.containsKey(a)) {
                List<Integer> list = new LinkedList<>();
                list.add(b);
                tree.put(a,list);
            }else {
                List<Integer> list = tree.get(a);
                list.add(b);
            }
            if (!tree.containsKey(b)) {
                List<Integer> list = new LinkedList<>();
                list.add(a);
                tree.put(b,list);
            }else {
                List<Integer> list = tree.get(b);
                list.add(a);
            }
        }

        dfs(1,n,tree,state);

        System.out.println(ans);
    }

    //返回值为以u为根的子树的大小
    private static int dfs(int u, int n, Map<Integer, List<Integer>> tree, boolean[] state) {
        state[u] = true;
        List<Integer> list = tree.get(u);  //当前节点的子树列表
        if (list.isEmpty()) {
            return 1;
        }
        int count = 1; //当前节点的子树的所有节点
        int res = 0;   //最大联通块的大小
        for (int i : list) {
            if(!state[i]){
                int child = dfs(i,n,tree,state);
                res = Math.max(res,child);
                count += child;
            }
        }
        res = Math.max(res,n-count); //子树的连通块、以u为根之外的所有节点大小
        ans = Math.min(res,ans);     //所有 分割方式里连通块的最大值的 最小值
        return count;
    }
}
