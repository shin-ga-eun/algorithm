package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1,2,3 더하기.

1,2,3 수 1개 이상을 이용해서 합을 나타냄
같은 수를 두 번 이상 연속해서 사용하면 안됨

D[i][j]
i = 1,2,3의 합으로 나타내는 방법의 수.
j = 마지막에 사용한 수.
 */
public class ex_15990 {
    static final long mod = 1000000009L;
    static final int limit = 100000;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[limit+1][4];

        //dp[i][1], dp[i][2], dp[i][3] 예외처리 및 dp 배열 초기화
        for(int i=1; i<=limit; i++){
            if(i >= 1) {
                dp[i][1] = dp[i-1][2] + dp[i-1][3];
                if(i==1){
                    dp[i][1] = 1;
                }
            }

            if(i >= 2) {
                dp[i][2] = dp[i-2][1] + dp[i-2][3];
                if(i==2){
                    dp[i][2] = 1;
                }
            }

            if(i >= 3) {
                dp[i][3] = dp[i-3][1] + dp[i-3][2];
                if(i==3){
                    dp[i][3] = 1;
                }
            }

            dp[i][1] %= mod;
            dp[i][2] %= mod;
            dp[i][3] %= mod;
        }


        //test n
        int t = Integer.parseInt(br.readLine());
        for(int test=0; test<t; test++){
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3])%mod);
        }

    }
}
