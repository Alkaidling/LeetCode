package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//1436、旅行终点站
class DestinationCity {
    public static void main(String[] args) {
        Solution solution = new DestinationCity().new Solution();
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("jMgaf WaWA","iinynVdmBz"));
        paths.add(Arrays.asList(" QCrEFBcAw","wRPRHznLWS"));
        paths.add(Arrays.asList("iinynVdmBz","OoLjlLFzjz"));
        paths.add(Arrays.asList("OoLjlLFzjz"," QCrEFBcAw"));
        paths.add(Arrays.asList("IhxjNbDeXk","jMgaf WaWA"));
        paths.add(Arrays.asList("jmuAYy vgz","IhxjNbDeXk"));
        String s = solution.destCity(paths);
        System.out.println(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths==null || paths.size()==0){
            return "";
        }
        HashSet<String> hashSet = new HashSet<>();
        for (List<String> path : paths) {
            hashSet.add(path.get(0));
        }
        for (List<String> path : paths) {
            if(!hashSet.contains(path.get(1))){
                return path.get(1);
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}