package leetcode.editor.cn.acwing.a;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-25 16:25
 * @ClassName BigDiv
 * @Description:  大数除法（大数 ÷ 小数）
 */

public class BigDiv {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int s2 = Integer.parseInt(reader.readLine());

        String[] res = div(s1,s2);

        System.out.println(res[0]);
        System.out.println(res[1]);

        reader.close();
    }

    private static String[] div(String s1, int n2) {
        String[] res = new String[2];
        StringBuilder builder = new StringBuilder();
        int[] n1 = new int[s1.length()];
        //低位在前，高位在后，倒序将大数存入数组
        for (int i = 0; i < n1.length; i++) {
            n1[i] = s1.charAt(n1.length-1 - i) - '0';
        }
        //res[0] = s1 / n2  res[1] = s1 % n2
        int carry = 0;
        for (int i = n1.length - 1; i >= 0; i--) {
            carry = carry * 10 + n1[i];
            builder.append(carry / n2);
            carry %= n2;
        }
        String str = builder.toString();
        //去除前导0
        int index = 0;
        for(;index < str.length() - 1; index++){
            if (str.charAt(index) != '0') {
                break;
            }
        }
        res[0] = str.substring(index);
        res[1] = String.valueOf(carry);
        return res;
    }
}
