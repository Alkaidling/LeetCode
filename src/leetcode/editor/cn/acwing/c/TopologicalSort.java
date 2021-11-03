package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 17:42
 * @ClassName TopologicalSort
 * @Description: 拓扑排序  AcWing 848. 有向图的拓扑序列
 */
public class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);  //n个点
        int m = Integer.parseInt(str[1]);  //m条边
        int[] in = new int[n+1];  //in[i] 表示 i 点的入度数
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            in[b]++;
            if(map.containsKey(a)){
                List<Integer> list = map.get(a);
                if(!list.contains(b)){
                    list.add(b);
                }else {
                    in[b]--;
                }
            }else {
                List<Integer> list = new LinkedList<>();
                list.add(b);
                map.put(a,list);
            }
        }
        List<Integer> list = bfs(map, in, n);
        if (list.size() == n) {
            for (int i : list) {
                writer.write(i + " ");
            }
        }else {
            System.out.println(-1);
        }
        writer.flush();
        reader.close();
        writer.close();
    }

    private static List<Integer> bfs(Map<Integer, List<Integer>> map, int[] in, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if (in[i] == 0) {
                queue.offer(new Pair(i,map.get(i)));
            }
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            List<Integer> list = pair.list;
            res.add(x);
            if (list == null) {
                continue;
            }
            for (int i : list) {
                in[i]--;
                if (in[i] == 0) {
                    queue.offer(new Pair(i,map.get(i)));
                }
            }
        }
        return res;
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
