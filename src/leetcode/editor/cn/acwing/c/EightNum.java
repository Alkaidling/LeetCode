package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 13:33
 * @ClassName EightNum
 * @Description: 845. 八数码
 */
public class EightNum {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().replace(" ", "");
        int res = bfs(s);
        System.out.println(res);
    }

    private static int bfs(String start) {
        String end = "12345678x";
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> d = new HashMap<>();
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        q.offer(start);
        d.put(start, 0);

        while (!q.isEmpty()) {
            String t = q.poll();
            int distance = d.get(t);
            if (t.equals(end)) {
                return distance;
            }
            //状态转移
            int k = t.indexOf('x');
            int x = k / 3, y = k % 3;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    char[] chars = t.toCharArray();
                    swap(chars, k, a * 3 + b);
                    String str = new String(chars);
                    if (!d.containsKey(str)) {
                        d.put(str, distance + 1);
                        q.offer(str);
                    }
                }
            }
        }
        return -1;
    }

    private static void swap(char[] chars, int k, int i) {
        char temp = chars[i];
        chars[i] = chars[k];
        chars[k] = temp;
    }
}
