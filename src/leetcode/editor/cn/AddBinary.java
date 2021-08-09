package leetcode.editor.cn;
//Java：二进制求和
class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String s = solution.addBinary("11111", "11");
        System.out.println(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String addBinary(String a, String b) {

        int carry = 0;//余数
        int sum = 0;//每位和

        StringBuilder builder = new StringBuilder();

        while(a.length()!=b.length()){//将两个二进制的数位数补齐,在短的前面添0
            if(a.length()>b.length()){
                b="0"+b;
            }else{
                a="0"+a;
            }
        }

        int i = a.length() - 1;
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0) {
            sum = carry;
            sum =sum + a.charAt(i) - '0' + b.charAt(i) - '0';
            i--;
            carry = sum / 2;
            builder.append(sum % 2);

            //int x = a.charAt(i)-'0';
            //int y = b.charAt(i)-'0';
            //sum = x + y +array;
            //if(sum >= 2){
            //    array = 1;
            //    sb.append(sum-2);
            //}else{
            //    array = 0;
            //    sb.append(sum);
            //}
        }

        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1)
            builder.append(carry);

        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}