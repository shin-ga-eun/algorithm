package lecture2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ex_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Deque<Character> deque = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        Character st = null;
        Character et = null;
        boolean isTag = false;

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='<'){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        deque.add(stack.pop());
                    }
                }
                st = input.charAt(i);
                deque.addLast(st);
                isTag = true;
                continue;
            }
            if(input.charAt(i)=='>'){
                et = input.charAt(i);
                deque.addLast(et);
                st = null;
                et = null;
                isTag = false;
                continue;
            }
            if(isTag) {
                deque.addLast(input.charAt(i));
            }
            else if(input.charAt(i)!=' '){
                stack.push(input.charAt(i));
            }
            else if(input.charAt(i)==' '){
                while(!stack.isEmpty()){
                    deque.addLast(stack.pop());
                }
                deque.addLast(' ');
            }

        }
        while(!stack.isEmpty()){
            deque.addLast(stack.pop());
        }
        while(!deque.isEmpty()){
            System.out.print(deque.pollFirst());
        }
    }
}
