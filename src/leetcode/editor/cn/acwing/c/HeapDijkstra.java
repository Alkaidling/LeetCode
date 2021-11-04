package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 15:07
 * @ClassName HeapDijkstra
 * @Description: 堆优化版的Dijkstra算法
 */
public class HeapDijkstra {

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
        int res = dijkstra(map, n);
        System.out.println(res);
    }

    private static int dijkstra(HashMap<Integer, List<Node>> map, int n) { //map为邻接表(node：该点的目标点、到目标点的距离)，n为点个数
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>((x, y) -> x.dis - y.dis);  //小顶堆，按照距离排序
        //起点进堆
        heap.offer(new Node(1, 0));
        while (!heap.isEmpty()) {
            //出队的点距离最小
            Node point = heap.poll();
            int x = point.aim, distance = point.dis;
            if (st[x]) {
                continue;
            }
            st[x] = true;
            //list为与point.aim相连的所有点
            List<Node> list = map.get(x);
            if (list == null) {
                continue;
            }
            for (Node node : list) {
                x = node.aim;
                //起点到point距离distance + point与当前点之间的距离
                if (dist[x] > distance + node.dis) {
                    dist[x] = distance + node.dis;
                    heap.offer(new Node(x, dist[x]));  //入队即为（ 点x，x到起点的距离dist[x] ）
                }
            }
        }
        if (dist[n] == 0x3f3f3f3f) {
            return -1;
        }
        return dist[n];
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
