package leetcode.editor.cn.acwing.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/06 15:17
 * @ClassName DivPrime
 * @Description: 试除法分解质因数
 */
public class DivPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(reader.readLine());
            List<int[]> list = divide(x);
            if (list != null) {
                for (int[] ints : list) {
                    System.out.println(ints[0] + " " + ints[1]);
                }
            }
            System.out.println();
        }
    }

    private static List<int[]> divide(int x) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                int s = 0;
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                list.add(new int[]{i, s});  //i：质因数的底数，s：质因数的指数
            }
        }
        if (x > 1) {
            list.add(new int[]{x,1});
        }
        return list;
    }
}
