package lecture2;

import java.util.Scanner;
import java.util.Stack;

public class ex_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int result = 0; //정답
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '(')
                stack.push('(');
            else {
                //레이저인경우
                if(input.charAt(i-1) == '(') {
                    stack.pop();
                    result += stack.size();
                }
                //쇠막대기인경
                else {
                    stack.pop();
                    result += 1;
                }

            }

        }

        System.out.println(result);



    }
}
