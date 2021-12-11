package leetcode.editor.cn;

//911、在线选举
class OnlineElection {
    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate tvc = new OnlineElection().new TopVotedCandidate(persons, times);
        System.out.println(tvc.q(3));
        System.out.println(tvc.q(12));
        System.out.println(tvc.q(25));
        System.out.println(tvc.q(15));
        System.out.println(tvc.q(24));
        System.out.println(tvc.q(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TopVotedCandidate {
        int[] persons;
        int[] times;
        int[] wins; //在times对应时刻的获胜者
        int n;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;
            n = times.length;
            wins = new int[n];
            int[] votes = new int[n];
            int max = -1;
            for (int i = 0; i < n; i++) {
                votes[persons[i]]++;
                if (votes[persons[i]] >= max) {
                    max = votes[persons[i]];
                    wins[i] = persons[i];
                }else {
                    wins[i] = wins[i - 1];
                }
            }
        }

        public int q(int t) {
            //times中找到值小于等于t的下标
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (times[mid] > t) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return wins[left];
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}