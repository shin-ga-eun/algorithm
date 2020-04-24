package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
합분해 문제.
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 문제.
덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우).
또한 한 개의 수를 여러 번 쓸 수도 있다.

dp[i][j] = i는 정수의 합, j는 정수의 갯수
 */
public class ex_2225 {
    static final int mod = 1000000000;
    static final int limit = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[limit+1][limit+1];

        //dp 배열 초기화
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = 1;
            }
        }

        //dp-방법1. 3중for문
        /*
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                for(int k=i; k>0; k--){
                    dp[i][j] += dp[k][j-1];
                    dp[i][j] %= mod;
                }
            }
        }
         */

        //dp-방법2. 점화식
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(i==1)
                    dp[i][j] = j;
                else if(j==1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= mod;
            }
        }

        System.out.println(dp[N][K]);

    }
}
