package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 030、插入、删除和随机访问都是 O(1) 的容器
class FortPu {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new FortPu().new RandomizedSet();
        System.out.println(randomizedSet.insert(-1));
        System.out.println(randomizedSet.remove(-2));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(-1));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.getRandom());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            map.put(list.get(list.size() - 1), index);
            map.remove(val);
            list.set(index, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}