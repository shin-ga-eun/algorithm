package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
스티커.
2행n열로 배치되어있는 스티커가 있다.
스티커를 한 장 떼면, 그 스티커와 변을 공유하는 스티커를 모두 사용할 수 없게 된다.
각 스티커에 점수를 매기고, 점수의 합이 최댓값이 되도록 스티커를 떼어내 최댓값을 구하는 문제.

 */

public class ex_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[3][n+1];
            int[][] dp = new int[3][n+1];

            //배열 sticker 초기화
            for (int i = 1; i <= 2; i++) {
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input);
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //dp 초기화
            dp[0][1] = 0;
            dp[1][1] = sticker[1][1];
            dp[2][1] = sticker[2][1];


            //dp
            for(int i=2; i<=n; i++){
                int max = 0;
                for(int j=0; j<3; j++){
                    max = Math.max(max, dp[j][i-1]);
                }
                dp[0][i] = max;
                dp[1][i] = Math.max(dp[0][i-1]+sticker[1][i], dp[2][i-1]+sticker[1][i]);
                dp[2][i] = Math.max(dp[0][i-1]+sticker[2][i], dp[1][i-1]+sticker[2][i]);
            }

            //정답
            int ans = 0;
            for(int j=0; j<3; j++){
                ans = Math.max(ans, dp[j][n]);
            }
            sb.append(ans+"\n");
        }

        System.out.println(sb);

    }
}
