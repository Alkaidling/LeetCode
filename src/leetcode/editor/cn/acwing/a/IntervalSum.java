package leetcode.editor.cn.acwing.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-27 16:38
 * @ClassName IntervalSum
 * @Description: 区间合并
 */

public class IntervalSum {
    private static int N = 100010;
    private static int[] a;
    private static ArrayList<int[]> list = new ArrayList();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++){
            a = new int[2];
            a[0] = scanner.nextInt();  //左端点
            a[1] = scanner.nextInt();  //右端点
            list.add(a);
        }
        //对列表中每个数组0位置元素升序排序
        list.sort((o1,o2) -> o1[0] - o2[0]);
        int k = 0;
        int r = Integer.MIN_VALUE;
        for(int a[] : list){
            //下一个区间左端点大于老区间右端点
            if(a[0] > r){
                k++;
            }
            //更新右端点
            r = Math.max(r,a[1]);
        }

        System.out.println(k);
    }

    public static List<int[]> intervalNums(List<int[]> list){
        list.sort((a,b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int[] nums : list) {
            //下一个区间左端点大于老区间右端点
            if (nums[0] > right) {
                if (left != Integer.MIN_VALUE) {
                    res.add(new int[] {left,right});
                }
                left = nums[0];
                right = nums[1];
            }else {
                right = Math.max(right,nums[1]);
            }
        }
        return res;
    }
}
