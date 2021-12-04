package leetcode.editor.cn.acwing;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/12/01 10:09
 * @ClassName t
 * @Description:
 */
public class t {

    static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                flag = true;
            }
        }).start();
        long start = System.currentTimeMillis();
        long i = 0;
        while (!flag) {
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end - start);
    }
}
