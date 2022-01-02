package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 058、日程表
class Fi9suh {
    public static void main(String[] args) {
        MyCalendar myCalendar = new Fi9suh().new MyCalendar();
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(33, 41));
        System.out.println(myCalendar.book(39, 45));
        System.out.println(myCalendar.book(33, 42));
        System.out.println(myCalendar.book(25, 32));
        System.out.println(myCalendar.book(26, 35));
        System.out.println(myCalendar.book(19, 25));
        System.out.println(myCalendar.book(3, 8));
        System.out.println(myCalendar.book(8, 13));
        System.out.println(myCalendar.book(18, 27));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {
        TreeMap<Integer,Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(start);  //大于等于当前开始时间的最小的开始时间
        if (entry != null && entry.getKey()  < end) {  //开始时间小于end
            return false;
        }
        entry = treeMap.floorEntry(start);  //小于等于当前开始时间最小的开始时间
        if (entry != null && entry.getValue() > start) {   //结束时间大于start
            return false;
        }
        treeMap.put(start,end);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}