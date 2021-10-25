package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-25 15:14
 * @ClassName BigDivide
 * @Description: 大数减法
 */

public class BigSub {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        String res = subtraction(s1,s2);

        System.out.println(res);

        reader.close();
    }

    private static String subtraction(String s1, String s2) {
        boolean flag = false;
        //转为大数减小数，若为小数减大数则flag = true
        if(!cmp(s1, s2)){
            String temp;
            temp = s1;
            s1 = s2;
            s2 = temp;
            flag = true;
        }
        StringBuilder builder = new StringBuilder();
        int[] n1 = new int[s1.length()];
        int[] n2 = new int[s2.length()];
        //低位在前，高位在后，倒序将大数存入数组
        for (int i = 0; i < n1.length; i++) {
            n1[i] = s1.charAt(n1.length-1 - i) - '0';
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = s2.charAt(n2.length-1 - i) - '0';
        }
        int t = 0;
        //两数相减
        for (int i = 0; i < n1.length; i++) {
            t = n1[i] - t;
            if (i < n2.length) {
                t -= n2[i];
            }
            builder.append((t + 10) % 10);
            if (t < 0) {
                t = 1;
            }else {
                t = 0;
            }
        }
        String str = builder.reverse().toString();
        //找到前导0的位置：从0到i ，若全为0则保留最后一位0
        int i = 0;
        for (; i < str.length()-1; i++) {
            if (str.charAt(i) != '0') {
                break;
            }
        }
        if (flag) {
            return '-' + str.substring(i);
        }else {
            return str.substring(i);
        }
    }
    //判断是否s1>=s2
    private static boolean cmp(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)){
                    return s1.charAt(i) > s2.charAt(i);
                }
            }
            return true;
        } else {
            return s1.length() > s2.length();
        }
    }
}
