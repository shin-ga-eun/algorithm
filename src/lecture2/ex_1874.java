package lecture2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//스택수열..
/*
1. 스택 peek값 <= 만들어야 하는 수 -> 가능
2. 가능한 경우 -> 입력된 수열 만들
 */
public class ex_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList();

        int n = sc.nextInt();
        int[] x = new int[n+1];
        int top = 1;

        for(int i=1; i<=n; i++){
            x[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            stack.push(i);
            result.add('+');
            while (!stack.empty() && stack.peek() == x[top]) {
                stack.pop();
                result.add('-');
                top++;
            }
        }

        if(stack.empty()){
            for(int size=0; size<result.size(); size++){
                System.out.println(result.get(size));
            }
        }
        else{
            System.out.println("NO");
        }



    }
}
