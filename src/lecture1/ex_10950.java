package lecture1;

//테스트케이스가 주어진 문제

import java.util.Scanner;

public class ex_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스

        for(int i=0; i<t; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(A+B);
        }
    }
}
