/*
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
*/
package lianxi0228;

public class test0228 {
	public static void main(String[] args) {
		Solution S = new Solution();
		String a = "1011";
		String b = "0101";
		String s = S.addBinary(a, b);
		System.out.println(s);
	}
}

class Solution {
    public String addBinary(String a, String b) {
     StringBuffer s = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;   //进位
        for( ;i >= 0||j >= 0; i--,j-- )
        {
        	//将两个字符串从后往前依次相加存入动态字符串中。存入的字符将是以逆序存入的。
        	//所以后面再写一个逆序方法就OK了。
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = a1 + b1 + c;
            
            if(tmp < 2)   //小于2  没有产生进位
            {
                s.append(tmp + "");
                c = 0;
            }
            else if(tmp == 2)  //进位为 1 ，本位为0
            {
                s.append("0");
                c = 1;
            }
            else
            {
            	s.append("1"); //进位为 1 ，本位 为 1
            	c = 1;
            }
        }
        if(c == 1)    
        {
            s.append("1");
        }
        return Reverse(s.toString());// 用逆序方法逆序
    }
    public String Reverse(String s)
    {
    	char[] chars = s.toCharArray();
        int i = 0;
        int len = s.length() - 1;
        while(i < len)
        {
            char tmp = chars[i];
            chars[i] = chars[len];
            chars[len] = tmp;
            i ++;
            len --;
        }
        return String.valueOf(chars);
    }
}