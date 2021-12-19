package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-22 11:38
 */
public class Z {
    public String convert(String s, int numRows)
    {
        //如果只有一行，则直接进行返回
        if(numRows == 1)
        {
            return s;
        }

        //新建一个sb数组进行存储每一行的字符串
        StringBuilder[]  res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();

        }

        int index = 0;  //字符个数
        int row = 0;    //行数

        int len = s.length();
        while(index<len)
        {
            while(index < len && row < numRows)
            {
                char ch = s.charAt(index++);
                res[row].append(ch);
                row++;
            }

            //字符串读取完毕
            if(index == len)
            {
                break;
            }

            row = numRows-2;

            while(index < len && row >= 0)
            {
                char ch = s.charAt(index++);
                res[row].append(ch);
                row--;
            }
            row += 2;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++)
            ans.append(res[i]);
        return ans.toString();

    }
}
