package leetcode.editor.cn.acwing.c;

import java.util.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/05 15:25
 * @ClassName Staining
 * @Description: 860. 染色法判定二分图
 */
public class Staining {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]); //n个点
        int m = Integer.parseInt(s[1]); //m条边
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            if (a == b) {
                continue;
            }
            if (!map.containsKey(a)) {
                map.put(a, new LinkedList<>());
            }
            List<Integer> list = map.get(a);
            if(!list.contains(b)){
                list.add(b);
            }
            if (!map.containsKey(b)) {
                map.put(b, new LinkedList<>());
            }
            List<Integer> list1 = map.get(b);
            if(!list1.contains(a)){
                list1.add(a);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        if (staining(map, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean staining(Map<Integer, List<Integer>> map, int n) {
        int[] color = new int[n + 1];
        boolean flag = true;
        for (int i = 1; i <= n; i++) { //所有点依次染色，如果有一个染色失败则不为二分图
            if (color[i] == 0) {
                if (!dfs(map, color, i, 1)) { //i点染色失败
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    //map为邻接表，color为染色数组，i为当前节点，c为i的颜色
    private static boolean dfs(Map<Integer, List<Integer>> map, int[] color, int i, int c) {
        color[i] = c;
        List<Integer> list = map.get(i);
        if (list == null) {  //i点没有邻接点直接认为i点染色成功
            return true;
        }
        for (int num : list) {  //遍历i的所有邻接点，将其染为与i相反的颜色(3-c)
            if (color[num] == 0) {
                if (!dfs(map, color, num, 3 - c)){  //num点染色失败
                    return false;
                }
            } else if (color[num] == c) {
                return false;
            }
        }
        return true;
    }
}
