package leetcode.editor.cn;
//Java：1109、航班预订统计
class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        //差分数组 bookings[] = [i, j, k]，可以类比为公交车，在 i 站，上车 k 人，坐车到 j 站，在 j+1 下车，返回每一站车上的人数
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2]; //在第 booking[0]-1 站上车 booking[2] 人
            if(booking[1] < n)  //等于n则为到终点站，前面所有站都不用减去人数
                answer[booking[1]] -= booking[2]; //在第 booking[1] 站下车 booking[2] 人
        }
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }

        //双循环 O(n²)  1676ms
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                answer[i-1] += booking[2];
            }
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}