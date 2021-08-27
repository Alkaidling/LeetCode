package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Java：295、数据流的中位数
class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        double median = medianFinder.findMedian();
        System.out.println(median);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    //利用大小堆来维护中位数
    // 时间addNum: O(log n) findMedian: O(1)
    // 空间 O(n)

    //queMax 和 queMin 分别记录大于中位数的数和小于等于中位数的数。
    // 当累计添加的数的数量为奇数时，queMin 中的数的数量比 queMax 多一个，此时中位数为 queMin 的队头。
    // 当累计添加的数的数量为偶数时，两个优先队列中的数的数量相同，此时中位数为它们的队头的平均值。
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    /** initialize your data structure here. */
    public MedianFinder() {
        queMin = new PriorityQueue<>((a,b) -> b-a); //从大到小排列
        queMax = new PriorityQueue<>((a,b) -> a-b); //从小到大排列
    }
    
    public void addNum(int num) {
        //num <= max{queMin}
        //num 小于等于中位数，将该数添加到queMin中。新的中位数将小于等于原来的中位数，因此将queMin中最大的数移动到queMax中。
        if(queMin.isEmpty() || num <= queMin.peek()){
            queMin.offer(num);
            if(queMax.size() + 1 < queMin.size())
                queMax.offer(queMin.poll());
        }
        //num > max{queMin}
        //num 大于中位数，将该数添加到queMax中。新的中位数将大于等于原来的中位数，因此将queMax中最小的数移动到queMin中。
        else {
            queMax.offer(num);
            if(queMax.size() > queMin.size())
                queMin.offer(queMax.poll());
        }
    }
    
    public double findMedian() {
        if(queMin.size() > queMax.size())
            return queMin.peek();
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}