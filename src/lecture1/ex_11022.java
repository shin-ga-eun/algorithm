package lecture1;

import java.util.Scanner;

public class ex_11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B));
        }
    }
}
