package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 16:35
 * @ClassName Spfa
 * @Description: AcWing 851. spfa求最短路
 */
public class Spfa {
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
        int res = spfa(map, n);
        if (res == -0x3f3f3f3f) {
            System.out.println("impossible");
        }else {
            System.out.println(res);
        }
    }

    private static int spfa(HashMap<Integer, List<Node>> map, int n) { //map为邻接表(node：该点的目标点、到目标点的距离)，n为点个数
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        st[1] = true;
        queue.offer(1);
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
                    if(!st[x]){
                        queue.offer(x);
                        st[x] = true;
                    }
                }
            }
        }
        if (dist[n] == 0x3f3f3f3f) {
            return -0x3f3f3f3f;
        }else {
            return dist[n];
        }
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
