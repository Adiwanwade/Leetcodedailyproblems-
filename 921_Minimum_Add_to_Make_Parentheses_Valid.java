import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                if(stack.peek()=='(')
                stack.pop();
                else{
                    stack.push(c);
                }
            } else if (c == ')') {
                stack.push(c);
            }
        }
        return stack.size();  
    }
}
