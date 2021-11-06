package leetcode.editor.cn.acwing.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/06 16:22
 * @ClassName GreatestDivisor
 * @Description: 872. 最大公约数 欧几里得算法（辗转相除）、更相减损
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            int res = getGCDByDivideBySubtract(a,b);
            System.out.println(res);
        }
    }

    private static int getGreatestCommonDivisor(int a, int b) {  //辗转相除
        return b == 0 ? a : getGreatestCommonDivisor(b,a % b);
    }

    private static int getGreatestCommonDivisor1(int a, int b) {  //辗转相除
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    public static int getGCDByDivideBySubtract(int max, int min) {  //更相减损
        if (max == min) {
            return max;
        }else if (max < min) {
            return getGCDByDivideBySubtract(min, max);
        }else{
            return getGCDByDivideBySubtract(max - min, min);
        }
    }

    public static int getGCDByDivideBySubtract1(int a, int b) {  //更相减损
        while (a != b) {
            if(a > b){
                a -= b;
            }else {
                b -= a;
            }
        }
        return a;
    }

}
