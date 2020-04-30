package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
오르막 수.
수의 자리가 오름차순을 이루는 수이며, 인접한 수가 같아도 오름차순이다.
수는 0으로 시작할 수 있다.
수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 문제.


 */
public class ex_11057 {
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10]; //j는 인접한 수

        //초기화
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= mod;
            }
        }

        //정답
        int ans = 0;
        for(int i=0; i<10; i++){
            ans += dp[N][i];
            ans %= mod;
        }

        System.out.println(ans);

    }
}
