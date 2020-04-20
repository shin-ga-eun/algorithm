package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
이친수 문제.

조건1) 첫번째 자리에는 0이 올 수 없다.
조건2) 1다음에 1이 올 수 없다. (11 이 부분문자열이 되면 안된다)
 */
public class ex_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[91];

        //예외처리
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);



    }
}
