package leetcode.editor.cn.acwing.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 13:47
 * @ClassName Bfs
 * @Description: 844. 走迷宫
 */
public class Bfs {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];  //地图
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int res = bfs(map);
        System.out.println(res);
    }


    private static int bfs(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int[][] d = new int[n][m]; //保存走过的路
        Pair[][] prev = new Pair[n][m];  //记录路径的上个位置坐标

        int[] dy = {0,1,0,-1}, dx = {-1,0,1,0};  //x，y上下左右四个方向
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0));

        while (!queue.isEmpty()) {  //bfs
            Pair pair = queue.poll();
            if (pair.x == n - 1 && pair.y == m - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                //x，y不越界，且不为障碍物，且未曾走过
                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0 && d[x][y] == 0) {
                    queue.offer(new Pair(x,y));
                    d[x][y] = d[pair.x][pair.y] + 1;
                    prev[x][y] = pair;  //保存上一步的坐标作为路径
                }
            }
        }

        int x = n - 1, y = m - 1;
        while (x != 0 || y != 0) {
            System.out.println(x + " " + y);
            Pair temp = prev[x][y];
            x = temp.x;
            y = temp.y;
        }

        return d[n-1][m-1];
    }
    //存储路径
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
