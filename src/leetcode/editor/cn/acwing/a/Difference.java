package leetcode.editor.cn.acwing.a;

import java.io.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-25 18:22
 * @ClassName Difference
 * @Description: 差分
 */

public class Difference {
    //static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    //static int N = 100010;  // 数据规模为 10w
    //static int[] b = new int[N];    // b数组为 arr数组的差分
    //static int[] arr = new int[N];  // arr数组为 b数组的前缀和
    //
    ////程序入口
    //public static void main(String[] args) throws IOException {
    //    // 初始化输入数据
    //    String[] s = reader.readLine().split(" ");
    //    int n = Integer.parseInt(s[0]);
    //    int m = Integer.parseInt(s[1]);
    //    String[] sArr = reader.readLine().split(" ");
    //    for (int i = 1; i <= n; i++)       // 注意下标为 1
    //        arr[i] = Integer.parseInt(sArr[i - 1]);
    //
    //    // 初始化 差分数组
    //    for (int i = 1; i <= n; i++) {
    //        // 相当于将 arr中全部看为 0, 则 b[n]中也全部都为 0, 再在其中区间 [i, i] 添加 arr[i], 求出 b[i]
    //        insert(i, i, arr[i]);
    //    }
    //
    //    // m次循环操作
    //    while (m-- > 0) {
    //        String[] sIn = reader.readLine().split(" ");
    //        int l = Integer.parseInt(sIn[0]), r = Integer.parseInt(sIn[1]), val = Integer.parseInt(sIn[2]);
    //        insert(l, r, val);
    //    }
    //
    //    // 求数组 arr插入元素后的值, 相当于求 b[n]的前缀和
    //    for (int i = 1; i <= n; i++) {
    //        arr[i] = arr[i - 1] + b[i];
    //        log.write(arr[i] + " ");
    //    }
    //
    //    // 释放资源
    //    reader.close();
    //    log.flush();
    //    log.close();
    //}

    //对a数组的a[left]到a[right]每个数加上k
    public int[] difference(int[] a,int left, int right, int k){
        int n = a.length;
        int[] dif = new int[n+1];
        // 初始化 差分数组
        for (int i = 1; i <= n; i++) {
            // 相当于将 a 中全部看为 0, 则 dif[n]中也全部都为 0, 再在其中区间 [i, i] 添加 a[i], 求出 dif[i]
            insert(dif,i, i, a[i]);
        }
        insert(dif,left,right,k);
        // 求数组 a 插入元素后的值, 相当于求 dif[n]的前缀和
        for (int i = 1; i <= n; i++) {
            dif[i] += dif[i-1];
            a[i-1] = dif[i];  //覆盖a的值
        }
        return a;
    }
    // 对差分数组进行插入操作
    private static void insert(int[] dif, int l, int r, int val) {
        dif[l] += val;
        dif[r + 1] -= val;
    }
}
