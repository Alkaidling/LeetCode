package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 115、重建序列
class Ur2n8P {
    public static void main(String[] args) {
        Solution solution = new Ur2n8P().new Solution();
        int[] o = {1};
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(2));
        System.out.println(solution.sequenceReconstruction(o, lists));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            if (seqs.isEmpty()) {
                return false;
            }
            int n = org.length;
            int[] in = new int[n + 1];
            Set<Integer>[] lists = new Set[n + 1];
            for (int i = 0; i < n + 1; i++) {
                lists[i] = new HashSet<>();
            }
            for (List<Integer> seq : seqs) {
                if (seq.get(0) > n || seq.get(0) < 1) {
                    return false;
                }
                for (int i = 1; i < seq.size(); i++) {
                    lists[seq.get(i - 1)].add(seq.get(i));
                    if (seq.get(i) > n || seq.get(i) < 1) {
                        return false;
                    }
                }
            }
            for (Set<Integer> set : lists) {
                for (int i : set) {
                    in[i]++;
                }
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                    list.add(i);
                }
            }
            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    return false;
                }
                int x = queue.poll();
                Set<Integer> set = lists[x];
                for (int i : set) {
                    in[i]--;
                    if (in[i] == 0) {
                        queue.offer(i);
                        list.add(i);
                    }
                }
            }
            if (list.size() < n) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (org[i] != list.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}