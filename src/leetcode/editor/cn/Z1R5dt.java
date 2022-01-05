package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 066、单词之和
class Z1R5dt {
    public static void main(String[] args) {
        MapSum mapSum = new Z1R5dt().new MapSum();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        Map<String,Integer> map;
        MapSum[] children;
        int count;

        public MapSum() {
            map = new HashMap<>();
            children = new MapSum[26];
        }

        public void insert(String key, int val) {
            MapSum mapSum = this;
            char[] chars = key.toCharArray();
            int preVal = map.getOrDefault(key,0);
            map.put(key,val);
            for (char aChar : chars) {
                int x = aChar - 'a';
                if (mapSum.children[x] == null) {
                    mapSum.children[x] = new MapSum();
                }
                mapSum = mapSum.children[x];
                mapSum.count -= preVal;
                mapSum.count += val;
            }
        }

        public int sum(String prefix) {
            MapSum mapSum = this;
            char[] chars = prefix.toCharArray();
            for (char aChar : chars) {
                int x = aChar - 'a';
                mapSum = mapSum.children[x];
                if (mapSum == null) {
                    return 0;
                }
            }
            return mapSum.count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}