
// Problem: Decode a String 
// GFG

class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num); 
                strStack.push(currStr); 
                currStr = new StringBuilder(); 
                num = 0; 
            } else if (ch == ']') {
                int repeat = numStack.pop(); 
                StringBuilder prevStr = strStack.pop(); 
                String repeatedStr = currStr.toString().repeat(repeat);
                currStr = prevStr.append(repeatedStr); 
            } else {
                currStr.append(ch); 
            }
        }
        return currStr.toString();
        
    }
}
