package leetcode.editor.cn.acwing.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/06 15:34
 * @ClassName SelectPrime
 * @Description: 868. 筛质数
 */
public class SelectPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int res = selectPrime(n);
        System.out.println(res);
    }

    private static int selectPrime(int n) {
        boolean[] st = new boolean[n + 1];
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                res++;
                for (int j = i + i; j <= n; j += i) {  //把i的倍数剔除
                    st[j] = true;
                }
            }
        }
        return res;
    }
}
