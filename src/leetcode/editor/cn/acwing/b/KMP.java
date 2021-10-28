package leetcode.editor.cn.acwing.b;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 18:04
 * @ClassName KMP
 * @Description:
 */

public class KMP {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //int n = Integer.parseInt(reader.readLine());
        //String pp = reader.readLine();
        //int m = Integer.parseInt(reader.readLine());
        //String ss = reader.readLine();
        //List<Integer> list = strStr(ss, pp);
        //for (Integer integer : list) {
        //    writer.write(integer + " ");
        //}
        //writer.flush();
        //writer.close();
        //reader.close();
        strStr("asfgdfsgsdfg","asdasdasaa");
    }

    // KMP 算法  pp在ss中出现的位置
    // ss: 原串(string)  pp: 匹配串(pattern)
    //public static List<Integer> strStr(String ss, String pp) {
    //    List<Integer> res = new ArrayList<>();
    //
    //    if (pp.isEmpty()){
    //        return res;
    //    }
    //
    //    // 分别读取原串和匹配串的长度
    //    int n = ss.length(), m = pp.length();
    //    // 原串和匹配串前面都加空格，使其下标从 1 开始
    //    ss = " " + ss;
    //    pp = " " + pp;
    //
    //    char[] s = ss.toCharArray();
    //    char[] p = pp.toCharArray();
    //
    //    // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
    //    int[] next = new int[m + 1];
    //    // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
    //    for (int i = 2, j = 0; i <= m; i++) {
    //        // 匹配不成功的话，j = next(j)
    //        while (j > 0 && p[i] != p[j + 1]) {
    //            j = next[j];
    //        }
    //        // 匹配成功的话，先让 j++
    //        if (p[i] == p[j + 1]) {
    //            j++;
    //        }
    //        // 更新 next[i]，结束本次循环，i++
    //        next[i] = j;
    //    }
    //    // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
    //    for (int i = 1, j = 0; i <= n; i++) {
    //        // 匹配不成功 j = next(j)
    //        while (j > 0 && s[i] != p[j + 1]) {
    //            j = next[j];
    //        }
    //        // 匹配成功的话，先让 j++，结束本次循环后 i++
    //        if (s[i] == p[j + 1]) {
    //            j++;
    //        }
    //        // 整一段匹配成功，直接返回下标
    //        if (j == m) {
    //            res.add(i-m);
    //            j = next[j];
    //        }
    //    }
    //    return res;
    //}

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        if (m == 0) {
            return 0;
        }
        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m];
        //next[0] = 0
        for (int i = 1, j = 0; i < m; i++) {
            // 如果 p[i] != p[j] 将 j 指针指向前一位置的next数组所对应的值，即将缩小对比的字串长度（如果j>0的话），此时继续比较
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            // 匹配成功的话，先让 j++
            if (p[i] == p[j]) {
                j++;
            }
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        //匹配过程
        for (int i = 0, j = 0; i < n; i++) {
            // 匹配不成功 j = next(j)
            // 如果 s[i] != p[j] 将 j 指针指向前一位置的next数组所对应的值，即将缩小对比的字串长度（如果j>0的话），此时继续比较
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j]) {
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
