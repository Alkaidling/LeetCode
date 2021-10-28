package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 15:30
 * @ClassName SimulateList
 * @Description:
 */

public class SimulateList {
    private static int N = 100010;  // 数据规模为 10w

    private static int head;                // 表示头结点的下标
    private static int[] e = new int[N];    // 表示结点 i的值
    private static int[] ne = new int[N];   // 表示结点 i的 next指针是多少
    private static int idx;                 // 表示存储当前结点已经使用结点的下一个结点

    // 初始化数据
    private static void init() {
        head = -1;  // 没有头结点
        idx = 0;    // 没有存入数据
    }

    // 将 val插到头结点
    private static void addToHead(int val) {
        e[idx] = val;   // 赋值
        ne[idx] = head; // 插入之前头结点的前面
        head = idx;     // 更新头结点信息
        idx++;          // idx向右移动
    }

    // 将下标是 k的点后面的点删掉
    private static void remove(int k) {
        ne[k] = ne[ne[k]];  // 让下标为 k的结点指向 下个结点的下个结点
    }

    // 将 val插入下标为 k的点的后面
    private static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    // 程序入口
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());

        init();     // 初始化操作

        // 进行 m次操作
        while (m-- > 0) {
            String[] s = reader.readLine().split(" ");

            if (s[0].equals("H")) {  // 插入头结点操作, 不能使用 ==, 要使用 equals()

                int val = Integer.parseInt(s[1]);
                addToHead(val);
            } else if (s[0].equals("I")) {   // 普通插入操作
                int k = Integer.parseInt(s[1]);
                int val = Integer.parseInt(s[2]);
                add(k - 1, val);    // 第 k个结点的下标为 k-1, 所以插入到下标为 k-1结点的后面
            } else {    // s[0] == "D", 删除操作
                int k = Integer.parseInt(s[1]);

                if (k == 0) {  // 题意: k = 0, 删除头结点
                    head = ne[head];
                } else
                    remove(k - 1);  // 第 k个结点的下标为 k-1, 所以是删除到下标为 k-1后面的后面
            }
        }

        // 打印输出
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
