package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import sun.misc.Regexp;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "()(((()(()()))))";
        str = "(66+9-(2*7+((8*7)*(99-8)-2)+(44-(33+9+(5+(5-8)*99)-(6+0)*66)+8)-(46+0)-88)-(9)+9)";
        try {
            checkBracketsUsingStack(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkBracketsUsingStack(String strWithBrackets) throws Exception {

        Stack<Character> stack = new <Character>Stack();
        for (int i = 0; i < strWithBrackets.length(); i++) {
            switch (strWithBrackets.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.size() == 0) {
                        throw new Exception(") more than (");
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        if (stack.size() > 0) {
            throw new Exception();
        } else {
            System.out.println("Success");
        }
    }
    
}