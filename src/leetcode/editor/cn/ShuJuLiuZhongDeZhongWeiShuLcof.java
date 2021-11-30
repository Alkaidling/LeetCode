package leetcode.editor.cn;

import java.util.PriorityQueue;

//剑指 Offer 41、数据流中的中位数
class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        MedianFinder medianFinder = new ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //执行耗时:66 ms,击败了84.97% 的Java用户 内存消耗:49.4 MB,击败了76.62% 的Java用户
    class MedianFinder {
        PriorityQueue<Integer> minHeap;  //小顶堆，保存比中位数大的部分
        PriorityQueue<Integer> maxHeap;  //大顶堆，保存比中位数小的部分

        public MedianFinder() {
            minHeap = new PriorityQueue<Integer>();
            maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                minHeap.offer(num);
            }else {
                if (num >= minHeap.peek()) {
                    minHeap.offer(num);
                }else {
                    maxHeap.offer(num);
                }
            }
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }else if(minHeap.size() < maxHeap.size()){
                return maxHeap.peek();
            }else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
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