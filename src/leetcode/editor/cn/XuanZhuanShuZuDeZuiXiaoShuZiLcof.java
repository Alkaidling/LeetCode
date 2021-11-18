package leetcode.editor.cn;

//Java：剑指 Offer 11、旋转数组的最小数字
class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        //int[] numbers = {2,2,2,0,1};
        //int[] numbers = {3,4,5,1,2};
        int[] numbers = {3, 3, 1, 3};
        int i = solution.minArray(numbers);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //2021.3.28 字节实习一面面试题   2021.7.14字节一面面试题
        public int minArray(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {  //最小值在左边，且不含mid
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {  //最小值在右边，可能为mid
                    right = mid;
                } else { // nums[mid] == nums[right]。nums[right]是不是最小值，都有一个它的替代品(即mid)，所以丢弃最末位
                    right--;
                }
            }
            return nums[left];
        }

        public int minArray1(int[] numbers) {
            //if (numbers.length == 1) {
            //    return numbers[0];
            //}
            //int start = 0;
            //int end = numbers.length - 1;
            //while (start <= end) {
            //    int mid = ((end - start) >> 1) + start;
            //    if(mid < end && numbers[mid] > numbers[mid + 1]){
            //        return numbers[mid + 1];
            //    }else if(mid > 0 && numbers[mid] < numbers[mid - 1]){
            //        return numbers[mid];
            //    }else if(numbers[mid] < numbers[end] && numbers[mid] > numbers[start]){
            //        return numbers[start];
            //    }else if(numbers[mid] >= numbers[end] && numbers[mid] >= numbers[start]){
            //        start = mid + 1;
            //    }else if(numbers[mid] <= numbers[end] && numbers[mid] <= numbers[start]){
            //        end = mid - 1;
            //    }
            //}
            //return numbers[start];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[i - 1]) {
                    return numbers[i];
                }
            }
            return numbers[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}