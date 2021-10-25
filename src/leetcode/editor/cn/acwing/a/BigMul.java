package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-25 16:03
 * @ClassName BigMul
 * @Description: 大数乘法（大数×小数）将小数看作一个整体去和大数相乘
 */

public class BigMul {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int s2 = Integer.parseInt(reader.readLine());

        String res = mul(s1,s2);

        System.out.println(res);

        reader.close();
    }

    private static String mul(String s1, int n2) {
        if(n2 == 0){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int[] n1 = new int[s1.length()];
        //低位在前，高位在后，倒序将大数存入数组
        for (int i = 0; i < n1.length; i++) {
            n1[i] = s1.charAt(n1.length-1 - i) - '0';
        }

        int t = 0;
        for (int i = 0; i < n1.length || t != 0; i++) {
            if(i < n1.length){
                t += n1[i] * n2;
            }
            builder.append(t % 10);
            t /= 10;
        }
        return builder.reverse().toString();
    }
}
