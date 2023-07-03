86. Valid Parenthesis

 public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> stack = new Stack<Character>();  
        for (int i=0;i<expression.length(); i++){
            char ch=expression.charAt(i);
            if(ch=='{'||ch=='['||ch=='('){
                stack.push(ch);
            }
            else {
                char top= stack.peek();
                if(!stack.isEmpty()){
                    if(ch==')' && top=='('|| 
                            ch==']' && top=='['||
                            ch=='}' && top=='{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return false;
      }
