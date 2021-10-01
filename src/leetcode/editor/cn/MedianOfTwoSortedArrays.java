package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//4、寻找两个正序数组的中位数
class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {2, 3};
        int[] nums2 = {1,4,6,7,9};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(log(min(m,n)))
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int leftLength = nums1.length;
            int rightLength = nums2.length;
            // 为了保证第一个数组比第二个数组小(或者相等)
            if (leftLength > rightLength) {
                return findMedianSortedArrays2(nums2, nums1);
            }
            // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
            // 两个数组长度之和为偶数时，当在长度之和上+1时，由于整除是向下取整，所以不会改变结果
            // 两个数组长度之和为奇数时，按照分割线的左边比右边多一个元素的要求，此时在长度之和上+1，就会被2整除，会在原来的数
            //的基础上+1，于是多出来的那个1就是左边比右边多出来的一个元素
            int totalLeft = (leftLength + rightLength + 1) / 2;
            // 在 nums1 的区间 [0, leftLength] 里查找恰当的分割线，
            // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
            int left = 0;
            int right = leftLength;
            // nums1[i - 1] <= nums2[j]
            //  此处要求第一个数组中分割线的左边的值 不大于(小于等于) 第二个数组中分割线的右边的值
            // nums2[j - 1] <= nums1[i]
            //  此处要求第二个数组中分割线的左边的值 不大于(小于等于) 第一个数组中分割线的右边的值
            // 循环条件结束的条件为指针重合，即分割线已找到
            while (left < right) {
                // 二分查找，此处为取第一个数组中左右指针下标的中位数，决定起始位置
                // 此处+1首先是为了不出现死循环，即left永远小于right的情况
                // left和right最小差距是1，此时下面的计算结果如果不加1会出现i一直=left的情况，而+1之后i才会=right
                // 于是在left=i的时候可以破坏循环条件，其次下标+1还会保证下标不会越界，因为+1之后向上取整，保证了
                // i不会取到0值，即i-1不会小于0
                // 此时i也代表着在一个数组中左边的元素的个数
                int i = left + (right - left + 1) / 2;
                // 第一个数组中左边的元素个数确定后，用左边元素的总和-第一个数组中元素的总和=第二个元素中左边的元素的总和
                // 此时j就是第二个元素中左边的元素的个数
                int j = totalLeft - i;
                // 此处用了nums1[i - 1] <= nums2[j]的取反，当第一个数组中分割线的左边的值大于第二个数组中分割线的右边的值
                // 说明右指针应该左移，即-1
                if (nums1[i - 1] > nums2[j]) {
                    // 下一轮搜索的区间 [left, i - 1]
                    right = i - 1;
                    // 此时说明条件满足，应当将左指针右移到i的位置，至于为什么是右移，请看i的定义
                } else {
                    // 下一轮搜索的区间 [i, right]
                    left = i;
                }
            }
            // 退出循环时left一定等于right，所以此时等于left和right都可以
            // 为什么left一定不会大于right?因为left=i。
            // 此时i代表分割线在第一个数组中所在的位置
            // nums1[i]为第一个数组中分割线右边的第一个值
            // nums1[i-1]即第一个数组中分割线左边的第一个值
            int i = left;
            // 此时j代表分割线在第二个数组中的位置
            // nums2[j]为第二个数组中分割线右边的第一个值
            // nums2[j-1]即第二个数组中分割线左边的第一个值
            int j = totalLeft - i;
            // 当i=0时，说明第一个数组分割线左边没有值，为了不影响
            // nums1[i - 1] <= nums2[j] 和 Math.max(nums1LeftMax, nums2LeftMax)
            // 的判断，所以将它设置为int的最小值
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            // 等i=第一个数组的长度时，说明第一个数组分割线右边没有值，为了不影响
            // nums2[j - 1] <= nums1[i] 和 Math.min(nums1RightMin, nums2RightMin)
            // 的判断，所以将它设置为int的最大值
            int nums1RightMin = i == leftLength ? Integer.MAX_VALUE : nums1[i];
            // 当j=0时，说明第二个数组分割线左边没有值，为了不影响
            // nums2[j - 1] <= nums1[i] 和 Math.max(nums1LeftMax, nums2LeftMax)
            // 的判断，所以将它设置为int的最小值
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            // 等j=第二个数组的长度时，说明第二个数组分割线右边没有值，为了不影响
            // nums1[i - 1] <= nums2[j] 和 Math.min(nums1RightMin, nums2RightMin)
            // 的判断，所以将它设置为int的最大值
            int nums2RightMin = j == rightLength ? Integer.MAX_VALUE : nums2[j];
            // 如果两个数组的长度之和为奇数，直接返回两个数组在分割线左边的最大值即可
            if (((leftLength + rightLength) % 2) == 1) {
                return Math.max(nums1LeftMax, nums2LeftMax);
            } else {
                // 如果两个数组的长度之和为偶数，返回的是两个数组在左边的最大值和两个数组在右边的最小值的和的二分之一
                // 此处不能被向下取整，所以要强制转换为double类型
                return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
            }
        }

        //O(log(m+n))
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public int getKthElement(int[] nums1, int[] nums2, int k) {
            /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * 这里的 "/" 表示整除
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;

            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }



        //时间 O(m+n) 空间 O(m+n)
        //将nums1和nums2数组合并为新数组arr，且保持合并后数组有序
        //执行耗时:2 ms,击败了100.00% 的Java用户 内存消耗:39.7 MB,击败了37.26% 的Java用户
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            int[] arr = new int[nums1.length+nums2.length];
            int len = arr.length; //len = m + n
            int n1 = 0;
            int n2 = 0;
            for (int i = 0; i < len; i++) {
                if (n1 < nums1.length && n2 < nums2.length) {
                    if(nums1[n1] < nums2[n2]){
                        arr[i] = nums1[n1++];
                    }else {
                        arr[i] = nums2[n2++];
                    }
                } else if (n1 < nums1.length) {
                    arr[i] = nums1[n1++];
                } else if (n2 < nums2.length) {
                    arr[i] = nums2[n2++];
                }
            }
            int index = len / 2;
            if (len % 2 == 0) {
                return (arr[index-1] + arr[index]) / 2.0;
            }else {
                return arr[index];
            }
        }

        //时间 O(nlog(n)) 空间 O(m+n)
        //使用一个大根堆和一个小根堆维护中位数(无序数组找  中位数的方法)，没有利用到数组有序的特点
        //执行耗时:9 ms,击败了9.87% 的Java用户 内存消耗:39.7 MB,击败了39.10% 的Java用户
        public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
            Queue<Integer> small = new PriorityQueue<>();
            Queue<Integer> big = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i <= nums1.length || i <= nums2.length; i++) {
                while (small.size() > big.size() + 1) {
                    big.offer(small.poll());
                }
                if (i < nums1.length) {
                    small.offer(nums1[i]);
                }
                if (i < nums2.length) {
                    small.offer(nums2[i]);
                }
            }
            if (small.size() == big.size()) {
                return (small.peek() + big.peek()) / 2.0;
            } else {
                return small.peek();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}