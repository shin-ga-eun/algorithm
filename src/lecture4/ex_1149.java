package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
RGB 거리 문제 => 부분합구하는 문제

RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구하는 문제.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

 */

public class ex_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N+1][3]; //[i][0] = r, [i][1] = g, [i][2] = b
        long[][] dp = new long[N+1][3]; //i = 집번호, j = 칠하려는 색깔

        //배열 rgb 초기화
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for(int j=0; j<3; j++) {
                int cost = Integer.parseInt(st.nextToken());
                rgb[i][j] = cost;
            }
        }

        //dp
        for(int i=1; i<=N; i++){
            for(int j=0; j<3; j++) {
                if (i == 1) {
                    dp[i][0] = rgb[i][0];
                    dp[i][1] = rgb[i][1];
                    dp[i][2] = rgb[i][2];
                } else {
                    if(j==0){
                        long min = Math.min(dp[i-1][1], dp[i-1][2]);
                        dp[i][j] = min+rgb[i][j];
                    } else if(j==1){
                        long min = Math.min(dp[i-1][0], dp[i-1][2]);
                        dp[i][j] = min+rgb[i][j];
                    } else if(j==2){
                        long min = Math.min(dp[i-1][0], dp[i-1][1]);
                        dp[i][j] = min+rgb[i][j];
                    }
                }
            }
        }

        long ans = dp[N][0];
        for(int i=1; i<3; i++){
            ans = Math.min(ans, dp[N][i]);
        }

        System.out.println(ans);

    }
}
