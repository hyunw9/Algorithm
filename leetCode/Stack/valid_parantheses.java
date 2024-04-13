package leetCode.Stack;

import java.util.Stack;

public class valid_parantheses {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i = 0;i<s.length(); i++){
      char now = s.charAt(i);
      if(now == '(' || now =='{' || now == '['){
        stack.push(now);
      }else if(now == ')'){
        if(!stack.isEmpty() && stack.peek()=='('){
          stack.pop();
        }else{
          return false;
        }
      }else if(now == '}'){
        if(!stack.isEmpty() && stack.peek()=='{'){
          stack.pop();
        }else{
          return false;
        }
      }else if(now == ']'){
        if(!stack.isEmpty() && stack.peek() == '['){
          stack.pop();
        }else{
          return false;
        }
      }
    }
    if(stack.isEmpty()){
      return true;
    }else{
      return false;
    }
  }

}
