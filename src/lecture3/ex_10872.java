package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 구하기
 */
public class ex_10872 {
    public static long factorial (int n) {
        if (n > 1)
            return n * factorial(n - 1);
        else if(n == 0)
            return 1;
        else
            return n*1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));



    }
}
