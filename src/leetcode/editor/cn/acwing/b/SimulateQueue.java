package leetcode.editor.cn.acwing.b;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 15:31
 * @ClassName SimulateQueue
 * @Description:
 */

public class SimulateQueue {
    static int N = 100010;
    static int[] queue = new int[N];
    public static void main(String[] args) throws Exception{
        //队列尾进头出，tt:下一个入队列位置，hh:下一个出队列位置
        int tt = 0;
        int hh = 0;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-- > 0){
            String opt = scanner.next();
            if ("push".equals(opt)){
                int x = scanner.nextInt();
                queue[tt++] = x;
            }else if ("pop".equals(opt)){
                hh++;
            }else if ("empty".equals(opt)){
                System.out.println(tt - hh == 0 ? "YES" : "NO");
            }else if ("query".equals(opt)){
                System.out.println(queue[hh]);
            }
        }
    }
}
