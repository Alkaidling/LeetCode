package leetcode.editor.cn.acwing.d;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/07 14:04
 * @ClassName Euler
 * @Description: 欧拉函数
 */
public class Euler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0) {
            int x = scanner.nextInt();
            int res = x;
            for(int i = 2; i <= x/i; i ++) {//可用筛法证明
                if(x%i==0) {
                    res = res/i * (i-1);
                    while(x%i==0) x = x/i;
                }
            }
            if(x!=1) res = res/x*(x-1);
            System.out.println(res);
        }
    }
}
