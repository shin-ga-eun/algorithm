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
        long dp[][] = new long[91][2];

        //예외처리
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][1]+dp[N][0]);



    }
}
