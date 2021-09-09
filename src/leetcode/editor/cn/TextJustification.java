package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//Java：68、文本左右对齐
class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        //String[] words = {"What","must","be","acknowledgment","shall","be"};
        //String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> strings = solution.fullJustify(words, 16);
        strings.forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strings = new ArrayList<>();
        int n = 0;  //单词个数
        while (n <= words.length) {
            int wordLen = 0; //单词长度
            int preNum = 0; //当前单词个数
            for (; n < words.length; n++) {
                if(maxWidth >= wordLen + preNum + words[n].length()){  //求出拼接后单词的长度，和拼接的单词个数
                    wordLen += words[n].length();
                    preNum++;
                }else{
                    break;
                }
            }
            StringBuilder builder = new StringBuilder(); //拼接后的字符串
            if (n == words.length) { //最后一行
                for (int i = n - preNum; i < n; i++) {
                    builder.append(words[i]);
                    if (maxWidth - builder.length() > 0) {
                        builder.append(' ');  //最后一行每个单词（不超max的情况下）后拼接一个空格
                    }
                }
                while (maxWidth - builder.length() > 0){  //每个单词拼接一个空格后如果没到max，则补充空格
                    builder.append(' ');
                }
                strings.add(builder.toString());
                break;
            }else {  //非最后一行
                int space = maxWidth - wordLen;  //总空格数
                int preSpace = 0;  //每个位置的空格数
                for (int i = n - preNum; i < n; i++) {
                    builder.append(words[i]);
                    if(i != n - 1){
                        preSpace = space % (n - i - 1) == 0 ? space / (n - i - 1) : space / (n - i - 1) + 1;  //每个位置的空格如果能平均分配则平分，否则求平均后加一
                        space = space - preSpace; //总空格减去已分配的空格
                        for (int j = 0; j < preSpace; j++) {
                            builder.append(' ');
                        }
                    }
                    if(preNum == 1){ //当前行只有一个单词，且不为最后一行，则在后面补充全部空格
                        for (int j = 0; j < maxWidth - words[i].length(); j++) {
                            builder.append(' ');
                        }
                    }
                }
                strings.add(builder.toString());
            }
        }
        return strings;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}