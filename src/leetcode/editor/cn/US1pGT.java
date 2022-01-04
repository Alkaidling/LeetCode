package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 064、神奇的字典
class US1pGT {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new US1pGT().new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode","judge"});
        System.out.println(magicDictionary.search("juage"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MagicDictionary {
        Map<Integer, ArrayList<String>> buckets;

        public MagicDictionary() {
            buckets = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                if (!buckets.containsKey(s.length())) {
                    ArrayList<String> list = new ArrayList<>();
                    buckets.put(s.length(),list);
                }
                ArrayList<String> list = buckets.get(s.length());
                list.add(s);
            }
        }

        public boolean search(String searchWord) {
            if (buckets.containsKey(searchWord.length())) {
                ArrayList<String> strings = buckets.get(searchWord.length());
                for (String string : strings) {
                    int t = 0;
                    for (int i = 0; i < string.length(); i++) {
                        if(searchWord.charAt(i) != string.charAt(i)){
                            t++;
                        }
                        if (t > 1) {
                            break;
                        }
                    }
                    if (t == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}