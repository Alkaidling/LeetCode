package leetcode.editor.cn.acwing.a;

import com.sun.media.sound.SoftTuning;
import javafx.util.Builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-25 14:50
 * @ClassName BigAdd
 * @Description: 高精度加法
 */

public class BigAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        String res = add(s1,s2);

        System.out.println(res);

        reader.close();
    }

    //s1,s2两个大整数相加
    private static String add(String s1, String s2) {
        int[] n1 = new int[s1.length()];
        int[] n2 = new int[s2.length()];
        StringBuilder builder = new StringBuilder();
        //低位在前，高位在后，倒序将大数存入数组
        for (int i = 0; i < n1.length; i++) {
            n1[i] = s1.charAt(n1.length-1 - i) - '0';
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = s2.charAt(n2.length-1 - i) - '0';
        }
        int t = 0;
        for (int i = 0; i < n1.length || i < n2.length; i++) {  //低位到高位相加
            if(i < n1.length){
                t += n1[i];
            }
            if (i < n2.length) {
                t += n2[i];
            }
            builder.append(t % 10);
            t /= 10;
        }
        if (t != 0) {
            builder.append(t);
        }
        return builder.reverse().toString();
    }
}
