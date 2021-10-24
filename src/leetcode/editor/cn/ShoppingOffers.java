package leetcode.editor.cn;

import java.util.*;

//638、大礼包
class ShoppingOffers {
    public static void main(String[] args) {
        Solution solution = new ShoppingOffers().new Solution();
        List<Integer> price = Arrays.asList(2,3,4);
        List<Integer> needs = Arrays.asList(1,2,1);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1,1,0,4),Arrays.asList(2,2,1,9));
        int i = solution.shoppingOffers(price, special, needs);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<List<Integer>, Integer> memo = new HashMap<>();

        //TODO
        // 记忆化递归
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int n = price.size();

            // 过滤不需要计算的大礼包，只保留需要计算的大礼包
            List<List<Integer>> filterSpecial = new ArrayList<>();
            for (List<Integer> sp : special) {
                int totalCount = 0, totalPrice = 0;
                for (int i = 0; i < n; ++i) {
                    totalCount += sp.get(i);
                    totalPrice += sp.get(i) * price.get(i);
                }
                if (totalCount > 0 && totalPrice > sp.get(n)) {
                    filterSpecial.add(sp);
                }
            }

            return dfs(price, needs, filterSpecial, n);
        }

        // 记忆化搜索计算满足购物清单所需花费的最低价格
        public int dfs(List<Integer> price, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
            if (!memo.containsKey(curNeeds)) {
                int minPrice = 0;
                for (int i = 0; i < n; ++i) {
                    minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
                }
                for (List<Integer> curSpecial : filterSpecial) {
                    int specialPrice = curSpecial.get(n);
                    List<Integer> nxtNeeds = new ArrayList<>();
                    for (int i = 0; i < n; ++i) {
                        if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                            break;
                        }
                        nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                    }
                    if (nxtNeeds.size() == n) { // 大礼包可以购买
                        minPrice = Math.min(minPrice, dfs(price, nxtNeeds, filterSpecial, n) + specialPrice);
                    }
                }
                memo.put(curNeeds, minPrice);
            }
            return memo.get(curNeeds);
        }

        //public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //    int res = 0;
        //    for (int i = 0; i < price.size(); i++) {  //不买礼包的总价钱
        //        res += price.get(i) * needs.get(i);
        //    }
        //
        //    int buy = dfs(price,special,needs,0);
        //    if (buy != 0) {
        //        res = Math.min(buy,res);
        //    }
        //    return res;
        //}

        //private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int total) {
        //    List<Integer> newNeeds = new ArrayList<>(needs);
        //    for (List<Integer> anSpecial : special) {
        //        int len = 0;
        //        for (int i = 0; i < needs.size(); i++) {
        //            if(anSpecial.get(i) <= needs.get(i)){
        //                len++;
        //            }
        //        }
        //        if(len == needs.size()){
        //            newNeeds.clear();
        //            for (int i = 0; i < price.size(); i++) {
        //                newNeeds.add(needs.get(i) - anSpecial.get(i));
        //            }
        //            total += anSpecial.get(anSpecial.size()-1);  //买礼包花费total
        //            //买 anSpecial 这个礼包
        //            return dfs(price,special,newNeeds,total);
        //        }
        //    }
        //
        //    for (int i = 0; i < price.size(); i++) {  //买完礼包剩下买单个所需的价钱
        //        total += price.get(i) * newNeeds.get(i);
        //    }
        //
        //    return total;
        //}

    }
//leetcode submit region end(Prohibit modification and deletion)

}