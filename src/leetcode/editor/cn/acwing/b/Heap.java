package leetcode.editor.cn.acwing.b;

import java.util.Arrays;
 
//小顶堆的代码实现
public class Heap {

    // 向下调整，顶端的大值往下调，主要用于删除和建堆,i表示要调整的节点索引，n表示堆的最后一个元素索引
    // 删除时候，i是0，建堆时候i从最后一个节点的父节点依次往前调整
    public static void fixDown(int[] data, int i, int n) {
        int num = data[i];
        int son = i * 2 + 1;
        while (son <= n) {
            if (son + 1 <= n && data[son + 1] < data[son]){
                son++;
            }
            if (num < data[son]){
                break;
            }
            data[i] = data[son];
            i = son;
            son = i * 2 + 1;
        }
        data[i] = num;
    }
 
    // 向上调整，小值往上走,用于增加,往上调整不需要制定最上面的索引，肯定是0
    public static void fixUp(int[] data, int n) {
        int num = data[n];
        int father = (n - 1) / 2;
        // data[father] > num是进入循环的基本条件,father减到0就不会减少了
        // 当n等于0时，father=0；进入死循环，所以当n==0时，需要跳出循环
        while (data[father] > num && n != 0) {
            data[n] = data[father];
            n = father;
            father = (n - 1) / 2;
        }
        data[n] = num;
    }
 
    // 删除,n表示堆的最后一个元素的索引
    public static void delete(int[] data, int n) {
        data[0] = data[n];
        data[n] = -1;
        fixDown(data, 0, n - 1);
    }
 
    // 增加,i表示要增加的数字，n表示增加位置的索引，是堆的最后一个元素
    public static void insert(int[] data, int num, int n) {
        data[n] = num;
        fixUp(data, n);
    }
 
    // 建堆,n表示要建堆的最后一个元素的索引
    public static void creat(int[] data, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--){
            fixDown(data, i, n);
        }
    }
 
    public static void main(String[] args) {
        int[] data = { 15, 13, 1, 5, 20, 12, 8, 9, 11 };
        // 测试建堆
        creat(data, data.length - 1);
        System.out.println(Arrays.toString(data));
        // 测试删除
        delete(data, data.length - 1);
        delete(data, data.length - 2);
        System.out.println(Arrays.toString(data));
        // 测试插入
        insert(data, 3, data.length - 2);
        System.out.println(Arrays.toString(data));
    }
 
}