package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {

    /**
     * ( [ {}
     * @param list
     * @return
     */

    public boolean test(String list){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');


        Stack<Character> stack = new Stack<>();

        char[] array = list.toCharArray();
        for (char c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (!stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return false;
    }



    public static void main(String[] args) {

    }
}
