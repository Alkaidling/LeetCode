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
        long start = System.currentTimeMillis();
        int i = solution.nQueen(8);
        long end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end - start);
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
}
