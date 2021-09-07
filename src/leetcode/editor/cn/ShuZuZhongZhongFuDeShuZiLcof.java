package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Java：剑指 Offer 03、数组中重复的数字
class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        int[] nums = {2,3,1,0,2,5,3};
        //int[] nums = {1,1};
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //⭐⭐⭐重排数组，对比下标和数字是否相等，相等则返回，不等则交换，时间O(n) 空间O(1)
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {  //两重循环，但每个数字最多只交换两次，所以时间O(n)
                    if(nums[i] == nums[nums[i]]){
                        return nums[i];
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return -1;
        }


        //二分查找找出重复数字 时间O(nlogn) 空间O(1)
        public int findRepeatNumber4(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = ((end - start)/2) + start;
                int count = countRange(nums,start,mid); //调用logn次，每次O(n)
                if(end == start){
                    if(count > 1){
                        return start;
                    }else{
                        break;
                    }
                }
                if(count > (mid - start + 1)){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return -1;
        }
        private int countRange(int[] nums, int start, int end) { //在start到end范围内，值也在这个范围中出现的次数
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] >= start && nums[i] <= end){
                    ++count;
                }
            }
            return count;
        }


        //先排序，后查找
        public int findRepeatNumber3(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == nums[i+1]){
                    return nums[i];
                }
            }
            return -1;
        }

        //存入哈希表，如果新数组包含下一个元素则直接返回，时间O(n) 空间O(n)
        public int findRepeatNumber2(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if(!set.contains(nums[i])){ //HashSet的contains方法是用hashcode查找，所以不用ArrayList
                    set.add(nums[i]);
                }else{
                    return nums[i];
                }
            }
            return -1;
        }
    //双重for循环找重复数字,时间O(n²) 空间O(1)
    public int findRepeatNumber1(int[] nums) {
        int p = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(p == nums[j]){
                    return p;
                }
            }
            p = nums[i];
        }
        return -1;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}