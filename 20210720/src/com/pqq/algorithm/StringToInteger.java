package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-22 17:05
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int len = str.length();
        //str.charAt(i)方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        //1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        //2、如果已经遍历完成（针对极端用例"   ")
        if (index == len) {
            return 0;
        }

        //3、如果出现符号字符，仅第一个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-')
        {
            index++;
            sign = -1;
        }

        //4、将后续出现的数字字符进行转换
        //不能使用long类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            //4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            //题目中说的，环境只能存储32位大小的有符号整数，因此，需要提前判断乘以10以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            //4.2 合法情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;

    }

    public static void main(String[] args) {
        StringToInteger st = new StringToInteger();
        String str = "42";
        int res = st.myAtoi(str);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }


}
