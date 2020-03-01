package lecture1;

//테스트케이스가 몇개인지 주어지지 않은 경우, EOF까지 입력받기.

import java.util.Scanner;

public class ex_10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(A+B);
        }

    }
}
