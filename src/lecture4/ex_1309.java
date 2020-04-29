package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
동물원 문제.

어떤 동물원에 가로로 두칸 세로로 N칸인 우리가 있다.
이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자.
사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.

(참고: https://sihyungyou.github.io/baekjoon-1309/)
dp[N][j] = N번째 줄에, j = 0: 사자 없음, 1: 사자 왼쪽에 있음, 2: 사자 오른쪽에 있음
 */

public class ex_1309 {
    static final int mod = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        //초기화
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
        }

        int ans = dp[N][0] + dp[N][1] + dp[N][2];
        ans %= mod;
        System.out.println(ans);
    }
}
