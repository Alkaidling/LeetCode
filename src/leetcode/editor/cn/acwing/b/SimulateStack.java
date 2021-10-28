package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 15:31
 * @ClassName SimulateStack
 * @Description:
 */

public class SimulateStack {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 100010;
    static int[] stack = new int[N];      // 数据规模为 10w
    static int tt = 0;                  // 指向栈顶的指针

    public static void push(int val) {
        stack[++tt] = val;
    }

    public static void pop() {
        tt--;
    }

    public static boolean empty() {
        return tt == 0;
    }

    public static int query() {
        return stack[tt];
    }

    // 程序入口
    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(reader.readLine());

        while (m-- > 0) {
            String[] s = reader.readLine().split(" ");
            if (s[0].equals("push")) {
                push(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop")) {
                pop();
            } else if (s[0].equals("query")) {
                System.out.println(query());
            } else if(s[0].equals("empty")) {
                if (empty()) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
