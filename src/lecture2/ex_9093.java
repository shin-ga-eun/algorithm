package lecture2;

import java.util.Scanner;
import java.util.Stack;

public class ex_9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            input+="\n";

            for(int size=0; size<input.length(); size++) {
                if (input.charAt(size) == ' ' || input.charAt(size) == '\n') {
                    while (!stack.isEmpty())
                        System.out.print(stack.pop());
                    System.out.print(" ");
                } else
                    stack.push("" + input.charAt(size));
            }
            System.out.println("");
        }
    }
}

