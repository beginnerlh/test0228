/*
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��

ʾ�� 1:
����: a = "11", b = "1"
���: "100"

ʾ�� 2:
����: a = "1010", b = "1011"
���: "10101"
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
        int c = 0;   //��λ
        for( ;i >= 0||j >= 0; i--,j-- )
        {
        	//�������ַ����Ӻ���ǰ������Ӵ��붯̬�ַ����С�������ַ��������������ġ�
        	//���Ժ�����дһ�����򷽷���OK�ˡ�
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = a1 + b1 + c;
            
            if(tmp < 2)   //С��2  û�в�����λ
            {
                s.append(tmp + "");
                c = 0;
            }
            else if(tmp == 2)  //��λΪ 1 ����λΪ0
            {
                s.append("0");
                c = 1;
            }
            else
            {
            	s.append("1"); //��λΪ 1 ����λ Ϊ 1
            	c = 1;
            }
        }
        if(c == 1)    
        {
            s.append("1");
        }
        return Reverse(s.toString());// �����򷽷�����
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