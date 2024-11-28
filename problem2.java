import java.util.Stack;

public class problem2 {
    public String decodeString(String s) {

       int n = s.length();
       Stack<Integer> numSt= new Stack<>();
       Stack<StringBuilder> strSt= new Stack<>();

       int currNum=0;
       StringBuilder currStr = new StringBuilder();

       for (int i = 0; i < n; i++) {
           char c = s.charAt(i);
           if (Character.isDigit(c)) {
               currNum = currNum * 10 + c - '0';
               
           } else if (c=='[') { // decode the baby - so store the parent
               numSt.push(currNum);
               strSt.push(currStr);
               currStr = new StringBuilder();
               currNum = 0;
           }
           else if (c==']') {
               int cnt= numSt.pop();
               StringBuilder baby= new StringBuilder();
               for (int j = 0; j < cnt; j++) {
                   baby.append(currStr);
               }
               StringBuilder parent= strSt.pop();
               parent.append(baby);
               currStr = parent;

           }
           else {
               currStr.append(c);
           }
       }
       return currStr.toString();
    }
}
