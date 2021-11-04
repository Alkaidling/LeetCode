package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 16:35
 * @ClassName Spfa
 * @Description: AcWing 852. spfa判断负环
 */
public class SpfaIs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);  //n个点
        int m = Integer.parseInt(s[1]);  //m条边
        HashMap<Integer, List<Node>> map = new HashMap<>(); //邻接表
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
            if (!map.containsKey(a)) {
                map.put(a, new LinkedList<>());
            }
            map.get(a).add(new Node(b, c));
        }
        boolean b = spfa(map, n);
        if(b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean spfa(HashMap<Integer, List<Node>> map, int n) { //map为邻接表(node：该点的目标点、到目标点的距离)，n为点个数
        int[] dist = new int[n + 1];
        int[] cnt = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            st[i] = true;
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;
            List<Node> list = map.get(t);
            if (list == null) {
                continue;
            }
            for (Node node : list) {
                int x = node.aim;
                if(dist[x] > dist[t] + node.dis){
                    dist[x] = dist[t] + node.dis;
                    cnt[x] = cnt[t] + 1;
                    if(cnt[x] >= n){
                        return true;
                    }
                    if(!st[x]){
                        queue.offer(x);
                        st[x] = true;
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int aim;  //到达点
        int dis;  //权重

        public Node(int aim, int dis) {
            this.aim = aim;
            this.dis = dis;
        }
    }
}
