package leetcode.editor.cn.acwing.c;

import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 16:59
 * @ClassName TreeBfs
 * @Description: 847. 图中点的层次
 */
public class TreeBfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //n个点
        int m = scanner.nextInt();  //m条边
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            if(map.containsKey(a)){
                List<Integer> list = map.get(a);
                list.add(b);
            }else {
                List<Integer> list = new LinkedList<>();
                list.add(b);
                map.put(a,list);
            }
        }
        int res = bfs(map,n);
        System.out.println(res);
    }

    private static int bfs(Map<Integer, List<Integer>> map,int n) {
        int[] d = new int[n+1];
        Arrays.fill(d,-1);
        d[1] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1,map.get(1)));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            List<Integer> list = pair.list;
            for (int i : list) {
                if(d[i] == -1){
                    d[i] = d[x] + 1;
                    if(map.containsKey(i)){
                        queue.offer(new Pair(i,map.get(i)));
                    }
                }
            }
        }
        return d[n];
    }
    static class Pair{
        int x;
        List<Integer> list;
        public Pair(int x, List<Integer> list) {
            this.x = x;
            this.list = list;
        }
    }
}
