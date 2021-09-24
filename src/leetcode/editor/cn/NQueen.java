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
        if(i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(record, i ,j)){
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }

        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}
}
