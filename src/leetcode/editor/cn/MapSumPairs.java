package leetcode.editor.cn;

import java.util.HashMap;

//677、键值映射
class MapSumPairs {
    public static void main(String[] args) {
        MapSum mapSum = new MapSumPairs().new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("aa"));
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("aaa"));
        System.out.println(mapSum.sum("bbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //字典树 执行耗时:12 ms,击败了66.71% 的Java用户 内存消耗:38 MB,击败了97.56% 的Java用户
    class MapSum {
        private int value;
        private MapSum[] children;
        private HashMap<String,Integer> map;

        public MapSum() {
            children = new MapSum[26];
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            MapSum mapSum = this;
            char[] chars = key.toCharArray();
            int n = chars.length;
            int preVal = map.getOrDefault(key,0);
            map.put(key,val);
            for (int i = 0; i < n; i++) {
                int x = chars[i] - 'a';
                if (mapSum.children[x] == null) {
                    mapSum.children[x] = new MapSum();
                }
                mapSum = mapSum.children[x];
                mapSum.value -= preVal;
                mapSum.value += val;
            }
        }

        public int sum(String prefix) {
            MapSum mapSum = this;
            char[] chars = prefix.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                int x = chars[i] - 'a';
                mapSum = mapSum.children[x];
                if (mapSum == null) {
                    return 0;
                }
            }
            return mapSum.value;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}