package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-24 17:01
 * @ClassName NumCubeRoot
 * @Description: 数的三次方跟
 */

public class NumCubeRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double n = Double.parseDouble(s);
        double left = -10000, right = 10000;  // 考虑 n为负数的情况

        while (right - left > 1e-8) {  // // 精度比所求精度高 2位
            double mid = (left + right) / 2;
            if (mid * mid * mid >= Math.abs(n))   // 不需要考虑边界问题
                right = mid;
            else
                left = mid;
        }
        if (n >= 0)
            System.out.println(String.format("%.6f", left)); // 保留 6位小数
        else
            System.out.println("-" + String.format("%.6f", left));
    }
}
