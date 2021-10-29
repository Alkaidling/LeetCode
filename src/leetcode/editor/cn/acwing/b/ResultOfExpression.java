package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-29 14:06
 * @ClassName ResultOfExpression
 * @Description: 表达式求值
 */

public class ResultOfExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        int res = resultOfExpression(str);

        System.out.println(res);
        reader.close();
    }

    //表达式求值  str = "(2+2)*(1+1)"  res = 8
    private static int resultOfExpression(String str) {
        Deque<Character> opStk = new ArrayDeque<>();   //运算符栈
        Deque<Integer> numStk = new ArrayDeque<>();    //数字栈
        Map<Character,Integer> map = new HashMap<>();  //记录运算符的优先级
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        char[] chars = str.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if(ch >= '0' && ch <= '9'){
                int x = 0, j = i;
                while (j < n && chars[j] >= '0' && chars[j] <= '9'){  //连续的数字直接合并
                    x = x * 10 + chars[j] - '0';
                    j++;
                }
                numStk.push(x);
                //i指向为连续数字的最后一位
                i = j - 1;
            }else if(ch == '('){  //左括号直接进栈
                opStk.push(ch);
            }else if(ch == ')'){  //右括号直接进行计算，知道找到左括号
                while (opStk.peek() != '('){
                    operation(opStk,numStk);
                }
                opStk.pop();
            }else{  //char[i] == + - * / 中的一个
                //操作符栈不为空，且栈内的操作符优先级大于等于当前操作符，则进行计算，否则直接进栈
                while (!opStk.isEmpty() && map.getOrDefault(opStk.peek(),0) >= map.get(ch)){
                    operation(opStk,numStk);
                }
                opStk.push(ch);
            }
        }
        while (!opStk.isEmpty()){  //若进栈完毕但，计算未完成，进行计算知道操作符栈为空
            operation(opStk,numStk);
        }
        return numStk.peek();
    }

    //计算
    private static void operation(Deque<Character> opStk, Deque<Integer> numStk) {
        int num2 = numStk.pop();
        int num1 = numStk.pop();
        int res = 0;
        char ch = opStk.pop();
        if(ch == '+'){
            res = num1+num2;
        }else if(ch == '-'){
            res = num1 - num2;
        }else if(ch == '*'){
            res = num1 * num2;
        }else if(ch == '/'){
            res = num1 / num2;
        }
        numStk.push(res);
    }
}
