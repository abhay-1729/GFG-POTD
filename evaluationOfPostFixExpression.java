
 //Problem: Evaluation of Postfix Expression
//GFG)
class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String s : arr) {
            if (isOperator(s)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                
                switch (s) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break; 
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop(); 
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
