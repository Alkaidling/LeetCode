package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-27 15:59
 * @ClassName BitOperator
 * @Description: 位运算
 */

public class BitOperator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(str[i]);
            System.out.print(theNumberOfFigureOne(num) + " ");
        }
    }

    //二进制中1的个数
    public static int theNumberOfFigureOne(int num){
        int res = 0;
        while (num > 0) {
            num &= num - 1;
            res++;
        }
        return res;
    }

    //二进制中最右边的1
    public static int theRightOfFigureOne(int num){
        return num & -num;
    }
}
