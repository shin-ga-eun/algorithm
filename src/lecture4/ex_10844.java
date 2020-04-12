package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    쉬운계단수 문제.
    45656과 같이 인접한 수가 1 차이나는 수를 계단수라고 한다.
    길이 N이 주어졌을 때, 길이가 N인 계단 수가 총 몇 개인지 구하는 문제.

    주의 할 점:
    메모리 때문에 mod 할 때
    dp에 저장할 때도 mod, 답을 더할 때도 mod를 해주어야 오류가 나지 않는다.


 */
public class ex_10844 {
    static final long mod = 1000000000L;
    static final int limit = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        long answer = 0;
        long[][] dp = new long[limit+1][10];

        //예외처리
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=input; i++){
            for(int j=1; j<=9; j++) {
                if(j == 1) {
                    if(i == 2)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = dp[i - 2][j] + dp[i - 1][j + 1];
                }
                else if(j == 9)
                   dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];

                dp[i][j] %= mod;
            }
        }

        //정답출력
        for(int i=1; i<=9; i++) {
            answer += dp[input][i];
            answer %= mod;
        }

        System.out.println(answer);
    }
}
