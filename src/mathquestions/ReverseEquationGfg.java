package mathquestions;

import java.util.Stack;

class ReverseEquationGfg {
    public static void main(String[] args) {
        System.out.println(reverseEqn("20-3+5*2")); //Output=2*5+3-20
        System.out.println(reverseEqn("5+2*56-2/4")); //Output=4/2-56*2+5
    }

    static String reverseEqn(String S)
    {
        // your code here
        Stack<String> sb = new Stack<>();
        String res = "";
        for(int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            if(ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                res += ch + "";
            } else {
                sb.push(res);
                res = "";
                sb.push(ch + "");
            }
        }
        sb.push(res);

        StringBuffer reversedString = new StringBuffer();
        while(!sb.isEmpty())
            reversedString.append(sb.pop());

        return reversedString.toString();
    }
}