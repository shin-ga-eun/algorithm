package lecture2;

import java.util.Scanner;
import java.util.Stack;

public class ex_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int t = sc.nextInt(); //테스트 수
        sc.nextLine(); //nextInt( ) 사용 후 nextLine( ) 사용시, 개행문자없애기.

        for(int i=0; i<t; i++){
            String command = sc.nextLine();

            if(command.contains("push")){
                int push_num = Integer.parseInt(command.substring(5));
//                command.indexOf(" ")+1)
                stack.push(push_num);
            }
            else if(command.equals("pop")){
                if(stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.pop());
            }
            else if(command.equals("size")){
                System.out.println(stack.size());
            }
            else if(command.equals("empty")){
                if(stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if(command.equals("top")){
                if(stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
            }


        }
    }
}
