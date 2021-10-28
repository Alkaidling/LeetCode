package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//869、重新排序得到 2 的幂
class ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2().new Solution();
        boolean b = solution.reorderedPowerOf2(10);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, int[]> map;
        {
            //0,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,
            //1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912
            map = new HashMap<>();
            map.put(1, new int[]{0,1,2,4,8});
            map.put(2, new int[]{16,32,64});
            map.put(3, new int[]{128,256,512});
            map.put(4, new int[]{1024,2048,4096,8192});
            map.put(5, new int[]{16384,32768,65536});
            map.put(6, new int[]{131072,262144,524288});
            map.put(7, new int[]{1048576,2097152,4194304,8388608});
            map.put(8, new int[]{16777216,33554432,67108864});
            map.put(9, new int[]{134217728,268435456,536870912});
        }
        public boolean reorderedPowerOf2(int n) {
            String str = String.valueOf(n);
            int len = str.length();
            int[] res = map.get(len);
            char[] nums = new char[len];
            for (int i = 0; i < len; i++) {
                nums[i] = str.charAt(i);
            }
            Arrays.sort(nums);
            str = new String(nums);
            for (int num : res) {
                String t = String.valueOf(num);
                char[] ch = new char[len];
                for (int i = 0; i < len; i++) {
                    ch[i] = t.charAt(i);
                }
                Arrays.sort(ch);
                t = new String(ch);
                if(t.equals(str)){
                    return true;
                }
            }
            return false;
        }


        //求全排列
        //预处理数组和集合耗时太长
        //执行耗时:399 ms,击败了7.88% 的Java用户 内存消耗:37.9 MB,击败了5.40% 的Java用户
        //public boolean reorderedPowerOf2(int n) {
        //    String str = String.valueOf(n);
        //    char[] nums = new char[str.length()];
        //    for (int i = 0; i < str.length(); i++) {
        //        nums[i] = str.charAt(i);
        //    }
        //    return allSort(nums, 0, nums.length - 1);
        //}
        //
        //private boolean allSort(char[] nums, int begin, int end) {
        //    if (begin == end) {
        //        if (nums[0] == '0') {
        //            return false;
        //        }
        //        int res = Integer.parseInt(String.valueOf(nums));
        //        res &= res - 1;
        //        if (res == 0) {
        //            return true;
        //        }else{
        //            return false;
        //        }
        //    } else {
        //        for (int i = begin; i <= end; i++) {
        //            swap(nums, begin, i);
        //            if(allSort(nums, begin + 1, end)){
        //                return true;
        //            }
        //            swap(nums, begin, i);  //回溯
        //        }
        //        return false;
        //    }
        //}
        //
        //public void swap(char[] array, int a, int b) {
        //    char tem = array[a];
        //    array[a] = array[b];
        //    array[b] = tem;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}