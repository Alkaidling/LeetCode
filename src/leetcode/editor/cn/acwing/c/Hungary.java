package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;
/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/05 16:26
 * @ClassName Hungary
 * @Description: 861. 二分图的最大匹配
 */
public class Hungary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]); //m条边
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            if (!map.containsKey(a)) {
                map.put(a, new LinkedList<>());
            }
            map.get(a).add(b);
        }

        int res = hungary(map,n1,n2);

        System.out.println(res);
    }

    //map为邻接表（key为左半部分的点，value为与key连接的右半部分的点）n1为左半部分点数量，点为1到n1。n2为右半部分点的数量，点为1到n2
    private static int hungary(Map<Integer, List<Integer>> map, int n1,int n2) {
        int res = 0;
        boolean[] st = new boolean[n2 + 1];
        int[] match = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st,false);
            if (find(match,st,map,i)) {  //如果i点能匹配到右半部分的点，则结果++
                res++;
            }
        }
        return res;
    }
    //match为右半部分点所匹配的左半部分的点（例如match[1] = 2,即左边点1匹配右边点2）st为左边点是否匹配过，map为邻接表，x为将要匹配的左边的点
    private static boolean find(int[] match,boolean[] st, Map<Integer, List<Integer>> map, int x) {
        List<Integer> list = map.get(x);  //list为x的邻接点集合
        if (list == null) {
            return false;
        }
        for (int num : list) {
            if(!st[num]){  //当前的邻接点未曾匹配过
                st[num] = true;
                if(match[num] == 0 || find(match,st,map,match[num])){  //当前点未被选择过 或者 已经选择了当前点的 左边的点(match[num])能够换一个点选择
                    match[num] = x;  //x点匹配成功
                    return true;
                }
            }
        }
        //遍历结束时，邻接点都被左边的点选择过了，并且这些点所对应的左边的点都无法更换
        return false;
    }
}
