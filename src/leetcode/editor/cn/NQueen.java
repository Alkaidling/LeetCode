package leetcode.editor.cn;

import org.omg.CORBA.MARSHAL;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-09-24 14:00
 * @ClassName NQueen
 * @Description:
 */
// n皇后问题
public class NQueen {
    public static void main(String[] args) {
        Solution solution = new NQueen().new Solution();
        Solution2 solution2 = new NQueen().new Solution2();
        int n = 8;
        int limit = n == 32 ? -1 : (1 << n) - 1;
        System.out.println(limit);

        long start = System.currentTimeMillis();
        int i = solution.nQueen(8);
        long end = System.currentTimeMillis();

        System.out.println("s1(n="+ n + "):  " + i);
        System.out.println(end - start + "ms");

        System.out.println();

        start = System.currentTimeMillis();
        i = solution2.nQueen(8);
        end = System.currentTimeMillis();

        System.out.println("s2(n=" + n + "):  " + i);
        System.out.println(end - start + "ms");
    }


class Solution{
    public int nQueen(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0,record,n);
    }

    private int process(int i, int[] record, int n) {
        if(i == n) {  //当所有行放完时，记录为一种情况
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(record, i ,j)){      //i行j列(0到n)是否可以放
                record[i] = j;          //找到可以放的位置，放到i行j列
                res += process(i + 1, record, n);      //递归求下一行及后面的情况
            }
        }
        return res;
    }

    //第i行j列是否可以放
    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            //共列（i以前的行已经放在过j列）   i以前行和j列共斜线（纵坐标差值绝对值 == 横坐标差值绝对值）
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(k - i)){
                return false;
            }
        }
        return true;
    }
}


class Solution2{
    public int nQueen(int n) {
        if (n < 0 || n > 32) {
            return 0;
        }
        //limit的值二进制为 右边n个1，左边补满0。
        //例如n=8时 limit=(0000 0000 0000 0000 0000 0000 1111 1111)2
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit,0,0,0);
    }
    //limit的二进制位上的1即为已经放的皇后，cloLim的1位 该列不能放，leftDiaLim、rightDiaLim的1为该位置 左边和右边成斜线的位置
    private int process(int limit,int cloLim, int leftDiaLim, int rightDiaLim){
        if (cloLim == limit) { //若相等 则列限制的所有位都为1，即放满了。
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        //将列限制，斜线限制求 或 运算即为全部限制。
        //再取 反 在 与 limit即为可以放的位置（pos二进制的1即为可以放的位置）
        pos = limit & (~(cloLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1); //mostRightOne即为pos最右侧的1
            pos = pos - mostRightOne;  //若pos==0，即为所有可放的位置计算完毕。
            //下一行可放的位置为：
            // 之前的列限制与上 mostRightOne，即为下一行的列限制。
            // 之前的左斜线的限制与上 mostRightOne 左移一位即为下一行的左斜线限制。
            // 之前的右斜线的限制与上 mostRightOne 右移一位即为下一行的左斜线限制。
            res += process(limit,cloLim | mostRightOne,(leftDiaLim | mostRightOne) << 1,(rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
}
