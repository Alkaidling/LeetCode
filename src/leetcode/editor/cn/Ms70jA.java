package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 067、最大的异或
class Ms70jA {
    public static void main(String[] args) {
        Solution solution = new Ms70jA().new Solution();
        int maximumXOR = solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        System.out.println(maximumXOR);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie {
            Trie[] children;

            public Trie() {
                children = new Trie[2];
            }

            public Trie build(int[] nums) {
                Trie root = new Trie();
                for (int num : nums) {
                    Trie node = root;
                    for (int i = 31; i >= 0; i--) {
                        int bit = (num >> i) & 1;
                        if (node.children[bit] == null) {
                            node.children[bit] = new Trie();
                        }
                        node = node.children[bit];
                    }
                }
                return root;
            }
        }

        public int findMaximumXOR(int[] nums) {
            Trie trie = new Trie();
            trie = trie.build(nums);
            int max = 0;
            for (int num : nums) {
                Trie node = trie;
                int xor = 0;
                for (int i = 31; i >= 0; i--) {
                    int bit = (num >> i) & 1;
                    if (node.children[1 - bit] != null) {
                        xor = (xor << 1) + 1;
                        node = node.children[1 - bit];
                    } else {
                        xor = xor << 1;
                        node = node.children[bit];
                    }
                }
                max = Math.max(xor, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}