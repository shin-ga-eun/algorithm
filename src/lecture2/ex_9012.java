package lecture2;

import java.util.Scanner;
import java.util.Stack;

public class ex_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<t; i++){
            String input = sc.nextLine();
            String result = "YES";
            Stack<Character> stack = new Stack<>();

            for(int size=0; size<input.length(); size++){
                if(input.charAt(size)=='('){
                    stack.push('(');
                }
                else {
                    if (stack.isEmpty()) {
                        result = "NO";
                        break;
                    } else
                        stack.pop();
                }
            }
            if(!stack.isEmpty())
                result = "NO";
            System.out.println(result);

        }

    }
}
